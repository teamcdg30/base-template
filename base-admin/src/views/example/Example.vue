<template>
  <div>
    예제 모음 <br>
    이름 : {{name}}<br>
    나이 : {{age}}
    <button @click="addAge(5)">나이 증가</button>

    <calculator :first="10" :second="20"></calculator>

    <li>
      <ul v-for="member in filteredList" :key="member.name">
        {{member.name}} / {{member.age}}
      </ul>
    </li>
  </div>
</template>

<script>
import Calculator from '../../components/Calculator'

export default {
  data() {
    return {
      name: 'choi',
      age: 34,
      list: [
        {
          name: '이승무',
          age: 30
        },
        {
          name: '강성현',
          age: 30
        },
        {
          name: '김준하',
          age: 31
        },
        {
          name: '곽욱현',
          age: 29
        }
      ]
    }
  },
  created() {
    console.log('생성 됨')
  },
  mounted() {
    console.log('마운티드')
  },
  computed: {
    filteredList() {
      let result = this.list.filter(item => {
        return item.age >= 30
      })
      return result
    }
  },
  watch: {
    age() {
      console.log(this.age)
    }
  },
  methods: {
    addAge(num) {
      this.age += num
    }
  },
  components: {
    Calculator
  }
}
</script>