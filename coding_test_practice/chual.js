function solution(n, k) {
  const pricePerLamb = 12000;
  const pricePerDrink = 2000;

  const freeDrinks = Math.floor(n / 10);

  const totalCost = n * pricePerLamb + (k - freeDrinks) * pricePerDrink;

  return totalCost;
}
