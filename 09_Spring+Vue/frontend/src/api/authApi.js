import api from '@/api';

const BASE_URL = '/api/member'; //기본 URL 설정
const headers = { 'Content-Type': 'multipart/form-data' };

export default {
  //username 중복 체크, true: 중복(사용불가), false: 사용 가능
  async checkUsername(username) {
    // 주어진 username 사용해서 중복 여부 체크하는 API 호출
    const { data } = await api.get(`${BASE_URL}/checkusername/${username}`);
    console.log('AUTH GET CHECKUSERNAME', data);
    return data;
  },

  async create(member) {
    //아바타 파일 업로드 - multipart 인코딩 필요 -> FormData 객체 사용
    const formData = new FormData();
    formData.append('username', member.username);
    formData.append('email', member.email);
    formData.append('password', member.password); //password: DTO property 명과 일치시켜야 함

    // 파일 첨부
    if (member.avatar) {
      // 아바타 이미지가 존재할 경우
      formData.append('avatar', member.avatar);
    }

    // {data}에 MemberDTO의 내용을 리턴 받게 됨
    // 회원 가입 요청을 API에 보내고 응답 데이터를 반환

    const { data } = await api.post(BASE_URL, formData, headers);

    console.log('AUTH PUT: ', data);
    return data;
  },

  async update(member) {
    //아바타 파일 업로드 - multipart 인코딩 필요 -> FormData 객체 사용
    const formData = new FormData();
    formData.append('username', member.username);
    formData.append('password', member.password); //password: DTO property 명과 일치시켜야 함
    formData.append('email', member.email);

    // 파일 첨부
    if (member.avatar) {
      // 아바타 이미지가 존재할 경우
      formData.append('avatar', member.avatar);
    }

    // {data}에 MemberDTO의 내용을 리턴 받게 됨
    // 회원 가입 요청을 API에 보내고 응답 데이터를 반환

    const { data } = await api.put(
      `${BASE_URL}/${member.username}`,
      formData,
      headers
    );
    console.log('AUTH PUT: ', data);
    return data;
  },

  async changePassword(formData) {
    const { data } = await api.put(
      `${BASE_URL}/${formData.username}/changepassword`,
      formData
    );
    console.log('AUTH PUT: ', data);
    return data;
  },
};
