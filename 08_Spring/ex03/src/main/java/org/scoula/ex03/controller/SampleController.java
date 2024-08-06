package org.scoula.ex03.controller;

import lombok.extern.log4j.Log4j;
import org.scoula.ex03.dto.SampleDTO;
import org.scoula.ex03.dto.TodoDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;

//Bean 등록 + Controller 명시
@Controller //이거에 의해서 Bean으로 등록됨(Context 두개 생김-> RootConfig: 전역, ServletConfig: Spring )
//servlet config가 component를 controller
//이 controller는 servlet config에 등록
@RequestMapping("/sample") //어느 url을 담당하느냐. 나중에 method들이 경로를 유출할건데 공퉁 url 파트임
//해당 클래스에 있는 메소드는 해당 url로 매핑하겠다
@Log4j
public class SampleController {
    //SampleController: POJO클래스
    //FrontController 아님
    @RequestMapping("") //메서드 마다 RequestMapping이 붙음
    //url: /sample
    //"": 모든 메서드에 대해서. get/post 모두 담당
    //localhost:8080/sample
    public void basic(){ //클래스 안에 있는 함수: 메소드
        //생성자는 클래스 이름이랑 같아야 생성자임. 이건 클래스 이름이랑 다름
        //void: 리턴값이 없다
        log.info("basic...............");
    }

    //GET과 POST 두 개 다 모두 처리하는 메소드
    //localhost:8080/sample/basic
    @RequestMapping(value = "/basic", method={RequestMethod.GET, RequestMethod.POST})
    //url: /sample/basic
    public void basicGet(){
        log.info("basic get...............");
    }

//    @RequestMapping + Get 요청을 합친 annotation, GET 요청만 처리 가능
    //localhost:8080/sample/basicOnlyGet
    @GetMapping("/basicOnlyGet")
    //url: /sample/basicOnlyGet
    public void basicGet2(){
        log.info("basic get only get................");
    }

    ////localhost:8080/sample/ex01
    @GetMapping("/ex01")
    public String ex01(SampleDTO dto){
        //요청해서 DTO 객체 생성
        //Handler Adapter가 담당
        //1) DTO 기본생성자 생성 => 없으면 실패해서 500에러
        //2) property(getter/setter에 의해 설정됨) 설정 => setter 호출
        //property이름이 name과 age. name -> setName(), age->setAge() 호출
        // => 실제 값이 seter의 매개변수로 넘어가고 필요하다면 타입 변환도. parseInt()를 Spring이 해줌
//        넣어준 값이 없을 경우 초기값으로 나온다
        log.info(""+dto);
        //dto>sampleDTO.java에서 @AllArgsConstructor 주석처리해야함.
        //기본 생성자가 없으므로

        return "ex01"; //View 이름
    }

    //localhost:8080/sample/ex02
    @GetMapping("/ex02")
    public String ex02(
            //RequestParam: 원하는 값만 받아올 수 있음
            //@RequestParam은 DTO 객체를 안쓰고 각각 파라미터를 받아줄 때 사용
            //필드 두 개 다 제대로 안 넣어주면 예외 발생, 개별 파라미터는 뷰로 전달 불가능
//            하나라도 안 넣어주면 예외. int를 String으로 넣으면 에러
            @RequestParam("name") String name,
            @RequestParam("age") int age) {
        log.info("name: " + name);
        log.info("age: " + age);

        return "ex02";
    }

//    체크 박스 처럼 여러개의 값이 오는 경우(배열 처리 필요)
    //localhost:8080/sample/ex02List
//    같은 이름으로 여러번 전달하는 경우 List나 배열로 받아올 수 있다
//    @GetMapping("/ex02List")
//    public String ex02List(@RequestParam("ids")ArrayList<String> ids){
//        log.info("ids: " + ids);
//        return "ex02List";
//    }

    //ArrayList가 편할지 배열이 편할지는 개발자의 선택
    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") String[] ids){
        log.info("array ids: " + Arrays.toString(ids));

        return "ex02List";
    }

    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTO list){
        log.info("list dtos: " + list);
        return "ex02Bean";
    }

    //localhost:8080/sample/ex03
    //localhost:8080/sample/ex03?title=test&dueDate=2023/01/01
    @GetMapping("/ex03")
    public String ex03(TodoDTO todo){
        log.info("todo: " + todo);
        return "ex03";
    }

    //localhost:8080/sample/ex04
    //localhost:8080/sample/ex04?name=aaa&age=11&page=9
    //page를 기본 자료형으로 넘기면 log에는 찍히지만, view로 전달되지 않는다.
    //따라서 @ModelAttribute로 전달해야 한다(request scope 저장)
    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page){
    //
        //int page: requestParam이 안붙어도 처리됨
        //변수명이 중요. 변수명에서 짝을 찾음
        //파라미터의 이름과 변수의 이름이 같으면 requestParam 생략 가능
        //@ModelAttribute("page") 전달하면 view에 나오게 됨
        log.info("dto: " + dto);
        log.info("page: " + page);

        return "sample/ex04";
    }

    //localhost:8080/sample/ex05
    //return값이 void일 경우 요청 url을 기준으로 jsp 파일을 찾는다
    // /WEB-INF/views/sample/ex05.jsp 파일을 찾게 됨
    @GetMapping("/ex05")
    public void ex05(){
        log.info("/ex05..........");
//        404에러: 1) 요청 경로가 잘못된 경우, 2) JSP 파일이 없는 경우
    }

    //http://localhost:8080/sample/ex06
    //해당 경로 접근시 http://localhost:8080/sample/ex06-2?name=AAA&age=10로 리다이렉트함
    @GetMapping("/ex06")
    public String ex06(RedirectAttributes ra){
        log.info("/ex06..........");
        //리다이렉트 시 요청 파라미터로 name과 age를 추가해준다
        ra.addAttribute("name", "AAA");
        ra.addAttribute("age", 10);
        //리다이렉트 시 "redirect:" 접두사를 사용한다
        return "redirect:/sample/ex06-2";
    }

    //http://localhost:8080/sample/ex07
    @GetMapping("/ex07")
    //@ResponseBody: application/json으로 응답해라. 반환된 객체가 JSON 형식으로 변환되어 보여지도록 한다
    //SampleDTO: json 문자열
    public @ResponseBody SampleDTO ex07(){
        log.info("/ex07..........");

        SampleDTO dto = new SampleDTO();
        dto.setAge(10);
        dto.setName("홍길동");

        return dto;
    }

    //http://localhost:8080/sample/ex08
    @GetMapping("/ex08")
    //ResponseEntity<String>: Body 객체 타입
    //ResponseEntity: json 형태의 body + 응답 헤더
    public ResponseEntity<String> ex08(){
        log.info("/ex08..........");

        String msg="{\"name\": \"홍길동\"}"; //body가 들어갈 json 형태의 문자열

        HttpHeaders header = new HttpHeaders();
        //Httpheaders 객체 생성 후 Content-Type 헤더 설정
        header.add("Content-Type", "application/json;charset=UTF-8");

        //msg: body, header: 헤더, HttpStatus: 상태코드
        //ResponseEntity 객체 내에 바디, 헤더, 상태코드(200) 반환
        return new ResponseEntity<>(msg, header, HttpStatus.OK);
    }

    //localhost:8080/sample/exUpload
    @GetMapping("/exUpload")
    //일반적으로 GET요청(리턴타입 void)이 올때 모양새
    //POST요청 (리턴타입 String)
    public void exUpload(){
        log.info("/exUpload..........");
    }

    //http://localhost:8080/sample/exUploadPost
    //exUploadPost: form에 action에 있는 경로와 일치해야함
    //MultipartFile 하나가 업로드한 파일 하나에 대응한다
    @PostMapping("/exUploadPost")
    //files: input의 name과 변수명(files)이 일치해야함
    public void exUploadPost(ArrayList<MultipartFile> files){
        for(MultipartFile file : files){
            log.info("---------------------------");
            log.info("name:" + file.getOriginalFilename());
            log.info("size:" + file.getSize());
        }
    }
}
