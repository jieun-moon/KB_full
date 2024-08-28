import axios from 'axios';

export const downloadFile = async (fileUrl) => {
  try {
    const link = document.createElement('a'); //a 노드 생성
    link.href = fileUrl; //a 노드의 href에 다운로드 파일 url 설정

    document.body.appendChild(link); //dom에 추가
    link.click(); // click이벤트 강제 발생
    document.body.removeChild(link); //dom에서 제거
  } catch (error) {
    console.error(error);
  }
};
