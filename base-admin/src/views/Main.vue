<template>
  <div>
    <!-- <b-breadcrumb :items="items"></b-breadcrumb> -->
    <nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <router-link tag="li" :to="item.to" class="breadcrumb-item" active-class="active" v-for="item in items" :key="item">
        <a>{{ item.text }}</a>
      </router-link>
  </ol>
</nav>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  data() {
    return {
      items: [
        {
          text: "회원 관리",
          to: "/member"
        },
        {
          text: "예제 모음",
          to: "/example"
        }
      ]
    };
  }
};
</script>
