import{u as h,a as b,b as v,r as y,c as w,d as g,o as c,e as d,f as s,w as u,v as m,t as x,g as k,h as a,i as V}from"./index-DRfppEvh.js";const D={class:"mt-5 mx-auto",style:{width:"500px"}},S=s("h1",{class:"my-5"},[s("i",{class:"fa-solid fa-right-to-bracket"}),a(" 로그인 ")],-1),B={class:"mb-3 mt-3"},N=s("label",{for:"username",class:"form-label"},[s("i",{class:"fa-solid fa-user"}),a(" 사용자 ID: ")],-1),q={class:"mb-3"},I=s("label",{for:"password",class:"form-label"},[s("i",{class:"fa-solid fa-lock"}),a(" 비밀번호: ")],-1),M={key:0,class:"text-danger"},R=["disabled"],T=s("i",{class:"fa-solid fa-right-to-bracket"},null,-1),C={__name:"LoginPage",setup(U){const l=h(),n=b(),p=v(),e=y({username:"",password:""}),o=w(""),f=g(()=>!(e.username&&e.password)),_=async()=>{console.log(e);try{await p.login(e),l.query.next?n.push({name:l.query.next}):n.push("/")}catch(i){o.value=i.response.data}};return(i,t)=>(c(),d("div",D,[S,s("form",{onSubmit:V(_,["prevent"])},[s("div",B,[N,u(s("input",{type:"text",class:"form-control",placeholder:"사용자 ID","onUpdate:modelValue":t[0]||(t[0]=r=>e.username=r)},null,512),[[m,e.username]])]),s("div",q,[I,u(s("input",{type:"password",class:"form-control",placeholder:"비밀번호","onUpdate:modelValue":t[1]||(t[1]=r=>e.password=r)},null,512),[[m,e.password]])]),o.value?(c(),d("div",M,x(o.value),1)):k("",!0),s("button",{type:"submit",class:"btn btn-primary mt-4",disabled:f.value},[T,a(" 로그인 ")],8,R)],32)]))}};export{C as default};
