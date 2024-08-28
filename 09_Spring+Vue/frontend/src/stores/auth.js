import { ref, computed, reactive } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios'; //인터셉터 적용이 안됨
//인터셉터가 적용된거 붙이려면 '@/api'가 붙어야 함

//초기 상태 정의
const initState = {
  token: '', //접근 토큰(JWT)
  user: {
    username: '', //사용자ID(비어있는 문자열은 boolean 검사시 false로 판정. 숫자 "0", 비어있는 문자열, undefined)
    email: '', //Email
    roles: [], //권한 목록
  },
};

//인증 관련 스토어 정의
export const useAuthStore = defineStore('auth', () => {
  const state = ref({ ...initState }); //상태 초기화
  //   읽기 전용 변수들
  const isLogin = computed(() => !!state.value.user.username); //로그인 여부(!!를 붙이면 boolean 타입으로 형변환 시키는 것과 같음).
  const username = computed(() => state.value.user.username); //로그인 사용자 ID
  const email = computed(() => state.value.user.email); //로그인 사용자 email.

  const login = async (member) => {
    // state.value.token = 'test token';
    // state.value.user = {username: member.username, email: member.username + '@test.com'};

    //api 호출
    const { data } = await axios.post('/api/auth/login', member);
    state.value = { ...data };

    // stringify: JSON 데이터를 'auth'라는 이름으로 String화시켜서 local storage에 저장(직렬화)
    localStorage.setItem('auth', JSON.stringify(state.value));
  };

  //로그아웃 함수
  const logout = () => {
    localStorage.clear(); //local storage 비우기
    state.value = { ...initState }; //상태 초기화
  };

  //토큰을 가져오는 함수
  const getToken = () => state.value.token;

  //   저장된 인증 정보를 불러오는 함수
  const load = () => {
    // 저장해둔 키값으로 로컬 스토리지에서 데이터를 가져온다
    const auth = localStorage.getItem('auth');
    if (auth != null) {
      // parse: String을 JSON 데이터로 변환(역직렬화)
      state.value = JSON.parse(auth);
      console.log(state.value);
    }
  };

  const changeProfile = (member) => {
    state.value.user.email = member.email;
    localStorage.setItem('auth', JSON.stringify(state.value));
  };

  load(); //스토어가 초기화될 때 인증 정보 로드

  return {
    state,
    username,
    email,
    isLogin,
    changeProfile,
    login,
    logout,
    getToken,
  };
  //   state: 디버그용으로 쓰고 있음(원래는 여섯개만 활용)
});
