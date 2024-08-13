//삭제 버튼의 click 이벤트 핸들러
// document.querySelector('.delete'): a태그 선택
// onclick: click이라는 이벤트 발생했을 때
document.querySelector('.delete').onclick = function() {
    if(!confirm('정말 삭제할까요?')) return;
    // getElementById: ID를 가지고 form 선택
    document.getElementById('deleteForm').submit();
}