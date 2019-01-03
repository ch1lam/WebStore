<template>
  <div>
    <Header msg="未登录"></Header>
    <el-row>
      <el-col :span="9">
        <blockquote></blockquote>
      </el-col>
      <el-col :span="6">
        <div v-show="showLogin">
          <el-input placeholder="请输入用户名" v-model="username"></el-input>
          <el-input type="password" placeholder="请输入密码" v-model="password"></el-input>
        </div>
        <div v-show="showRegister">
          <el-input placeholder="请输入用户名" v-model="newusername"></el-input>
          <el-input type="password" placeholder="请输入密码" v-model="newpassword"></el-input>
        </div>
      </el-col>
      <el-col :span="9">
        <blockquote></blockquote>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="9">
        <blockquote></blockquote>
      </el-col>
      <el-col :span="6">
        <div v-show="showLogin">
          <el-button type="primary" v-on:click="login">登录</el-button>
          <span v-on:click="toRegister">没有账号？立即注册</span>
        </div>
        <div v-show="showRegister">
          <el-button type="primary" v-on:click="register">注册</el-button>
          <span v-on:click="toLogin">已有账号？马上登录</span>
        </div>
      </el-col>
      <el-col :span="9">
        <blockquote></blockquote>
      </el-col>
    </el-row>
  </div>
</template>


<script>
import axios from "axios";
import Header from "../../components/header";

export default {
  components: {
    Header
  },
  data() {
    return {
      showLogin: true,
      showRegister: false,
      username: "",
      password: "",
      newusername: "",
      newpassword: "",
      info: null
    };
  },
  methods: {
    login() {
      if (this.username === "" || this.password == "") {
        this.$message({
          type: "error",
          message: "用户名或密码不能为空"
        });
      } else {
        axios
          .get("http://localhost:8080/login", {
            params: {
              username: this.username,
              password: this.password
            }
          })
          .then(res => {
            this.info = res;
            if (res.data === true) {
              this.$router.push({ path: "/home" });
              this.$message({
                type: "success",
                message: "登录成功"
              });
            }
          });
      }
    },
    register() {
      if (this.newusername === "" || this.newpassword == "") {
        this.$message({
          type: "error",
          message: "用户名或密码不能为空"
        });
      } else {
        axios
          .get("http://localhost:8080/register", {
            params: {
              username: this.newusername,
              password: this.newpassword
            }
          })
          .then(res => {
            if (res.data === true) {
              this.$router.push({ path: "/login" });
              this.$message({
                type: "success",
                message: "注册成功"
              });
            }
          })
          .catch(error => {
            console.log(error);
            this.$message({
              type: "error",
              message: "用户名已存在"
            });
          });
      }
      axios
        .get("http://localhost:8080/hello")
        .then(res => (this.info = res.data));
    },
    showInfo() {
      axios
        .get("http://localhost:8080/user")
        .then(res => (this.info = res.data));
    },
    toRegister() {
      this.showRegister = true;
      this.showLogin = false;
      this.$notify({
        title: "请注册"
      });
    },
    toLogin() {
      this.showRegister = false;
      this.showLogin = true;
      this.$notify({
        title: "请登录"
      });
    }
  }
};
</script>

<style scoped>
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
.el-button {
  width: 100%;
}
</style>

