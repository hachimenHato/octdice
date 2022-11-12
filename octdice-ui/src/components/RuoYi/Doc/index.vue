<template>
  <div>
    <svg-icon icon-class="question" @click="goto" />
  </div>
</template>

<script>
export default {
  name: 'RuoYiDoc',
  data() {
    return {
      url: 'http://doc.hachimen.info'
    }
  },
  methods: {
    goto() {
      window.open(this.url)
    }
  }
}
</script>