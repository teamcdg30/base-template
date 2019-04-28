import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from '../views/Main'
import Member from '../views/member/Member'
import Example from '../views/example/Example'


Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  routes: [
    { 
      path: '/', 
      component: Main ,
      children: [
        { 
          path: 'member', 
          component: Member 
        },
        { 
          path: 'example', 
          component: Example 
        }
      ]
    }
  ]
})

export default router