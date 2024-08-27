<script setup>
import { reactive, ref } from 'vue'; //vue에서 반응형 상태 관리와 참조를 위한 기능
import { useRouter } from 'vue-router'; //Vue-Router 사용하기 위한 훅
import authApi from '@/api/authApi'; //인증 관련 API 함수들

const router = useRouter();
const avatar = ref(null);
const checkError = ref('');

// 회원가입 form에 사용될 반응형 테스트 객체 생성
const member = reactive({
  //테스트용 초기화
  username: 'hong',
  email: 'hong@gmail.com',
  password: '12',
  password2: '12',
  avatar: null,
});

const disableSubmit = ref(true); //제출 버튼 비활성화 여부

//username 중복 체크
// function checkUsername(){}의 구조를 화살표 함수로 바꾼 것
const checkUsername = async () => {
  if (!member.username) {
    // 사용자 이름이 입력되지 않은 경우 경고 메세지 표시
    return alert('사용자 ID를 입력하세요.');
  }

  // 이름이 중복된 경우 제출 버튼 비활성화
  disableSubmit.value = await authApi.checkUsername(member.username); //여기서 값이 바껴서 :disabled="disableSubmit"이 바뀜
  console.log(disableSubmit.value, typeof disableSubmit.value);
  // 제출 버튼이 비활성화된 상태면 ID가 사용중이면 에러 메세지 출력
  checkError.value = disableSubmit.value
    ? '이미 사용중인 ID입니다.'
    : '사용가능한 ID입니다.';
};

//username 입력 핸들러
const changeUsername = () => {
  disableSubmit.value = true; //ID 입력 중엔 항상 제출 버튼을 비활성화
  if (member.username) {
    checkError.value = 'ID 중복 체크를 하셔야 합니다.';
  } else {
    checkError.value = '';
  }
};

// await: 서버(api)에서 받아올 때 사용)
const join = async () => {
  if (member.password != member.password2) {
    // 비밀번호와 비밀번호 확인이 일치하지 않는 경우 경고
    return alert('비밀번호가 일치하지 않습니다.');
  }

  // 객체에 files라는 키값이 0 이상 일 때
  if (avatar.value.files.length > 0) {
    // 아바타 파일이 업로드된 경우 member 객체에 추가
    member.avatar = avatar.value.files[0];
  }

  try {
    // create의 안쪽에서 post 요청 보내주고 있음
    await authApi.create(member); //회원가입
    router.push({ name: 'home' }); //회원 가입 성공 시, 첫 페이지로 이동 또는 로그인 페이지로 이동
  } catch (e) {
    console.error(e); //에러 발생 시 콘솔에 출력
  }
};
</script>

<template>
  <div class="mt-5 mx-auto" style="width: 500px">
    <h1 class="my-5">
      <i class="fa-solid fa-user-plus"></i>
      회원 가입
    </h1>

    <!-- form을 제출할 경우 기본 동작인 서버 전송은 하지 않고 join 메소드만 부르겠다 -->
    <!-- @이벤트 핸들러. prevent: 디폴트 액션을 막는 액션 -->
    <!-- 디폴트 액션: 실제 서버로 submit 하는 것(SPA에서는 막아야함) -->
    <form @submit.prevent="join">
      <div class="mb-3 mt-3">
        <label for="username" class="form-label">
          <i class="fa-solid fa-user"></i>
          사용자 ID :
          <button
            type="button"
            class="btn btn-success btn-sm py-0 me-2"
            @click="checkUsername"
          >
            ID 중복 확인
          </button>

          <!-- text-primary: 파란색 -->
          <!-- text-danger: 빨간색 -->
          <!-- 제출 버튼의 활성화 여부에 따라 글씨 스타일을 다르게 적용 -->
          <!-- {{  }}: v-text -->

          <span :class="disableSubmit.value ? 'text-primary' : 'text-danger'">{{
            checkError
          }}</span>
        </label>
        <!-- placeholder: 힌트 주는 것 -->
        <!-- v-model: 양방향 바인딩(html과 script 끼리) -->
        <!-- v-bind: 단방향 바인딩(script에서 html로만 바인딩(=script에서 읽어오기만 가능)) -->
        <input
          type="text"
          class="form-control"
          placeholder="사용자 ID"
          id="username"
          @input="changeUsername"
          v-model="member.username"
        />
      </div>
      <!-- ref="avatar" -->
      <!-- avatar=ref(null)에서 초기화한 곳에서 위의 ref를 참조하라 -->
      <div>
        <label for="avatar" class="form-label">
          <i class="fa-solid fa-user-astronaut"></i>
          아바타 이미지:
        </label>
        <input
          type="file"
          class="form-control"
          ref="avatar"
          id="avatar"
          accept="image/png, image/jpeg"
        />
      </div>

      <div class="mb-3 mt-3">
        <label for="email" class="form-label">
          <i class="fa-solid fa-envelope"></i>
          email
        </label>
        <input
          type="email"
          class="form-control"
          placeholder="Email"
          id="email"
          v-model="member.email"
        />
      </div>
      <!-- v-model: 양방향 바인딩 -->
      <div class="mb-3">
        <label for="password" class="form-label">
          <i class="fa-solid fa-lock"></i> 비밀번호:
        </label>
        <input
          type="password"
          class="form-control"
          placeholder="비밀번호"
          id="password"
          v-model="member.password"
        />
      </div>

      <!-- type이 password인 경우,  비밀번호 안 보이게 가려주는 -->
      <div class="mb-3">
        <label for="password" class="form-label">
          <i class="fa-solid fa-lock"></i> 비밀번호 확인:
        </label>
        <input
          type="password"
          class="form-control"
          placeholder="비밀번호 확인"
          id="password2"
          v-model="member.password2"
        />
      </div>
      <!-- disableSubmit의 값에 따라 버튼 활성화 여부가 변한다 -->
      <button
        type="submit"
        class="btn btn-primary mt-4"
        :disabled="disableSubmit"
      >
        <i class="fa-solid fa-user-plus"></i>
        확인
      </button>
    </form>
  </div>
</template>
