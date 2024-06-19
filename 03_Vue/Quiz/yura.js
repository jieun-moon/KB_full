// function Person (name, gender, age, address, job){
//     this.이름=name;
//     this.성별=gender;
//     this.나이=age;
//     this.주소=address;
//     this.직업=job;
// }
let person = {
         
        Person.prototype.printInfo=function(){
            return `${this.이름}의 성별은 ${this.성별}이며 ${this.나이}입니다. 주소는 ${this.주소}이며 직업은 ${this.직업}입니다.`
}
    };

yura.printInfo();