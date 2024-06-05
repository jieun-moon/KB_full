function solution(array, height) {
  const tallerPeople = array.filter((personHeight) => personHeight > height);
  return tallerPeople.length;
}
