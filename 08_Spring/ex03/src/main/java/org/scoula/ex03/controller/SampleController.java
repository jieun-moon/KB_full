package org.scoula.ex03.controller;

import lombok.extern.log4j.Log4j;
import org.scoula.ex03.dto.SampleDTO;
import org.scoula.ex03.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
