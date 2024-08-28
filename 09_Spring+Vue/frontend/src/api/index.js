import config from '@/config';
import axios from 'axios';

import { useAuthStore } from '@/stores/auth';
import router from '@/router';

const instance = axios.create({
  timeout: 1000,
});

//요청 인터셉터
instance.interceptors.request.use(
  (config) => {
    //JWT 추출
    const { getToken } = useAuthStore();
    const token = getToken();
    if (token) {
      //토큰이 있는 경우
      config.headers['Authorization'] = `Bearer ${token}`; //(중요!)
      console.log(config.headers.Authorization);
    }

    //config.headers : 요청 헤더
    return config;
  },
  (error) => {
    //요청 중 에러가 난 경우
    return Promise.reject(error);
  }
);

//응답 인터셉터
instance.interceptors.response.use(
  (response) => {
    if (response.status === 200) {
      return response;
    }
    if (response.status === 404) {
      return Promise.reject('404: 페이지 없음 ' + response.request);
    }
    //정상 응답인 경우(200, 404)
    return response;
  },
  async (error) => {
    // ?. => null이 아닌 경우에만 뒤에 값 참조
    if (error.response?.status === 401) {
      //null이 아니면 status 참조
      const { logout } = useAuthStore();
      logout(); //(응답인터셉터 핵심)!. 초기화해주겠다는 뜻
      router.push('/auth/login?error=login_required'); //(응답인터셉터 핵심)!
      return Promise.reject({ error: '로그인이 필요한 서비스입니다.' });
    }
    //에러 응답인 경우(401, 403, 305, 500 등)
    // 이 중에서 401, 403 에러가 나왔을 때 대처를 해야 함

    return Promise.reject(error);
  }
);

export default instance; //인터셉터가 적용된 axios 인스턴스
