<template>
	<div>
		<el-form :model="user" :rules="rules" class="login-containter" ref="loginForm">
			<h3 class="login-title">系统登录</h3>
			<el-form-item prop="username">
				<el-input type="text" v-model="user.username" placeholder="账号"></el-input>
			</el-form-item>
			<el-form-item prop="password">
				<el-input type="password" v-model="user.password" placeholder="密码"></el-input>
			</el-form-item>
			<div style="display: flex;height: 20px;margin-bottom: 10px;">
				<img :src="imgurl" /><a href="#" style="margin-right: 110px; text-decoration: none;" @click="getCode()">看不清</a>
				<el-checkbox class="login-remember" v-model="remember">记住用户名</el-checkbox>
			</div>
			<el-form-item prop="checkCode">
				<el-input v-model="user.checkCode" placeholder="请输入验证码"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" style="width: 100%;" @click="login()">登录</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default {
		data() {
			let checkCodeValidate = (rule, value, callback) => {
				let url = "user/checkCode";
				axios.post(url, `checkCode=${this.user.checkCode}`).then(resp => {
					if (!resp.data) {
						callback(new Error("验证码输入错误"));
					} else {
						callback();
					}
				});
			};
			return {
				user: {
					username:''
				},
				remember: false,
				rules: {
					username: [{
							required: true,
							message: '请输入用户名',
							trigger: ['blur', 'change']
						},
						{
							pattern: /^[a-zA-Z0-9_\u4e00-\u9fa5\u3400-\u4DB5]{2,10}$/,
							message: '用户名长度在2-10个字符之间'
						}
					],
					password: [{
							required: true,
							message: '请输入密码',
							trigger: ['blur', 'change']
						},
						{
							min: 4,
							message: '密码长度至少为4位',
							trigger: ['blur', 'change']
						},
						{
							max: 18,
							message: '密码长度最大为18位',
							trigger: ['blur', 'change']
						}
					],
					checkCode: [{
							required: true,
							message: '请输入验证码',
							trigger: ['blur', 'change']
						},
						{
							pattern: /^\w{4}$/,
							message: '验证码长度必须为4位'
						},
						{
							validator: checkCodeValidate,
							trigger: 'blur'
						}
					]
				},
				imgurl: 'http://localhost:8089/user/getCode',
			}
		},
		methods: {
			login() {
				this.$refs["loginForm"].validate(valid => {
					if (valid) {
						let url = "user/login";
						axios.post(url,
							`username=${this.user.username}&password=${this.user.password}&checkCode=${this.user.checkCode}`).then(resp => {
							if (resp && resp.data.result == "ok") {
								/* this.$message({
									message: "登陆成功！",
									type: "success"
								}); */
								
								this.$setSessionStorage("user",resp.data.data);

								if (this.remember) {
									this.$setLocalStorage("username", this.user.username);
								} else {
									this.$removeLocalStorage("username");
								}
								this.$router.push("/mainpage");
							}
						});
					}
				});

			},
			getCode() {
				this.imgurl = this.imgurl + "?" + Math.random();
			}
		},
		created() {
			if (this.$getLocalStorage("username")) {
				this.user.username = this.$getLocalStorage("username")
				this.remember = true;
			}
		}
	}
</script>

<style scoped="scoped">
	.login-containter {
		width: 360px;
		margin: 100px auto 10px auto;
		border: 1px solid #eaeaea;
		padding: 35px 35px 15px 35px;
		border-radius: 15px;
		box-shadow: 0 0 25px #cac6c6;
	}

	.login-title {
		text-align: center;
		color: #505458;
		margin: 0px auto 40px auto;
	}

	.login-remember {
		margin: 0px 0px 35px 0px;
	}
</style>
