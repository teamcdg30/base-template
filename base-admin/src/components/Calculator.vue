<template>
  <div>
    <input type="number" name="first" v-model="first" @keyup="calculate">
    <input type="text" name="op" v-model="op" @keyup="calculate">
    <input type="number" name="second" v-model="second" @keyup="calculate">
    <input type="number" name="result" v-model="result" disabled>
  </div>
</template>

<script>
export default {
  props: {
    first: {
      type: Number,
      default: 0
    },
    second: {
      type: Number,
      default: 0
    }
  },
  data() {
    return {
      result: 0,
      op: '+'
    }
  },
  mounted() {
    this.calculate()
  },
  methods: {
    calculate() {
      this.result = this.first + this.second
    }
  }
}
</script>
