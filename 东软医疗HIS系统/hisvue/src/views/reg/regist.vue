<template>
	<div>
		<el-button size="mini" type="primary" @click="add()">挂号</el-button>
		<el-button size="mini" type="primary" @click="clearr()">清空</el-button>

		<div>
			<br>
			挂号信息
			<br>
			<el-form size="mini" :model="addList" :rules="rules" ref="loginForm">
				<el-row>
					<el-col :span="4">
						<el-form-item prop="casenumber">
							<span class="scolor">*</span> 病历号：
							<el-input style="width: 100px;" placeholder="输入病例号" v-model="addList.casenumber"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="4">
						<el-form-item prop="realname">
							<span class="scolor">*</span> 姓 名：
							<el-input style="width: 100px;" placeholder="输入姓名" v-model="addList.realname"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="4">
						<el-form-item prop="constantitem">
							<span class="scolor">*</span> 性 别：
							<el-select placeholder="性别" style="width: 100px;" v-model="addList.constantitem.id">
								<el-option v-for="list in sexlist" :key="list.id" :label="list.constantname" :value="list.id">

								</el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="6">
						<el-form-item prop="age">
							<span class="scolor">*</span> 年 龄：
							<el-input style="width: 100px;" placeholder="输入年龄" v-model="addList.age"></el-input>
							<el-select placeholder="性别" style="width: 100px;" v-model="addList.agetype">
								<el-option label="岁" :key="1" value="岁">岁</el-option>
								<el-option label="月" :key="2" value="月">月</el-option>
								<el-option label="天" :key="3" value="天">天</el-option>
							</el-select>
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="4">
						<el-form-item prop="birthdate">
							出生日期：
							<el-date-picker type="date" placeholder="出生日期" style="width: 150px;" v-model="addList.birthdate"></el-date-picker>
						</el-form-item>
					</el-col>
					<el-col :span="6">
						<el-form-item prop="idnumber">
							身份证号：
							<el-input style="width: 200px;" placeholder="在此输入身份证号" v-model="addList.idnumber"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="6">
						<el-form-item prop="homeaddress">
							家庭住址：
							<el-input style="width: 200px;" placeholder="在此输入家庭住址" v-model="addList.homeaddress"></el-input>
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="4">
						<el-form-item prop="settlecategory">
							<span class="scolor">*</span> 结算类别：
							<el-select placeholder="类别" style="width: 100px;" v-model="addList.settlecategory.id">
								<el-option v-for="list in setList" :key="list.id" :label="list.settlename" :value="list.id">

								</el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="4">
						<el-form-item prop="visitdate">
							<span class="scolor">*</span> 看诊日期：
							<el-date-picker type="date" value-format="yyyy-MM-dd" placeholder="看诊日期" style="width: 150px;" v-model="addList.visitdate"
							 @change="getByDate()"></el-date-picker>
						</el-form-item>
					</el-col>
					<el-col :span="4">
						<el-form-item prop="noon">
							<span class="scolor">*</span> 午别：
							<el-select placeholder="午别" style="width: 100px;" v-model="addList.noon" @change="getDept()">
								<el-option v-for="list in dateList" :key="list.id" :label="list.noon" :value="list.noon">

								</el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="4">
						<el-form-item prop="department">
							<span class="scolor">*</span> 挂号科室：
							<el-select placeholder="挂号科室" style="width: 100px;" v-model="addList.department.id" @change="getRegistLv()">
								<el-option v-for="list in departmentList" :key="list.id" :label="list.department.deptname" :value="list.department.id">

								</el-option>
							</el-select>
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="4">
						<el-form-item prop="registlevel">
							<span class="scolor">*</span> 号 别：
							<el-select placeholder="号别" style="width: 100px;" v-model="addList.registlevel.id" @change="getDoctor()">
								<el-option v-for="(item,index) in registlevelList" :key="index" :label="item" :value="index+1">

								</el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="4">
						<el-form-item prop="user1">
							<span class="scolor">*</span> 看诊医生：
							<el-select placeholder="看诊医生" style="width: 100px;" v-model="addList.user1.id">
								<el-option v-for="list in doctorList" :key="list.id" :label="list.user.realname" :value="list.id">

								</el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="4">
						<el-form-item>
							初始号额：
							<el-input placeholder="初始号额" style="width: 100px;"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="4">
						<el-form-item>
							已用号额：
							<el-input placeholder="已用号额" style="width: 100px;"></el-input>
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="4">
						<el-form-item prop="isbook">
							病历本：
							<input type="checkbox" v-model="addList.isbook">
						</el-form-item>
					</el-col>
					<el-col :span="4">
						<el-form-item prop="price">
							<span class="scolor">*</span> 应收金额：
							<el-input placeholder="应收金额" style="width: 100px;" v-model="price"></el-input>
						</el-form-item>
					</el-col>
					<el-col :span="4">
						<el-form-item prop="charge">
							<span class="scolor">*</span> 收费方式：
							<el-select placeholder="收费方式" style="width: 100px;" v-model="charge">
								<el-option v-for="list in chargeList" :key="list.id" :label="list.constantname" :value="list.id">

								</el-option>
							</el-select>
						</el-form-item>
					</el-col>
				</el-row>

			</el-form>

		</div>

	</div>
</template>

<script>
	export default {
		data() {
			return {
				list: {
					constantitem: {},
				},
				sexlist: [],
				setList: [],
				departmentList: [],
				registlevelList: [],
				doctorList: [],
				chargeList: [],
				dateList: [],
				addList: {
					constantitem: {},
					settlecategory: {},
					department: {},
					registlevel: {},
					user1: {
						id: ''
					},
					user2: {

					}
				},
				price: '',
				charge: '',
				rules: {
					casenumber: [{
						required: true,
						message: '请输入用户名',
						trigger: ['blur', 'change']
					}, ],
				}
			}
		},
		created() {
			let url = "register/getAll";
			axios.post(url).then(resp => {
				this.list = resp.data.data;
				// console.log(this.list);
			});

			url = "register/selectSex";
			axios.post(url).then(resp => {
				this.sexlist = resp.data.data;
				// console.log(this.sexlist);
			});

			url = "register/settleid"
			axios.post(url).then(resp => {
				this.setList = resp.data.data;
			});

			/* url = "register/selDepartment";
			axios.post(url).then(resp=>{
				this.departmentList = resp.data.data;
			}); */

			/* url = "register/selRegistLevel";
			axios.post(url).then(resp=>{
				this.registlevelList = resp.data.data;
			}); */

			/* url = "register/selDoctor";
			axios.post(url).then(resp=>{
				this.doctorList = resp.data.data;
			}); */

			url = "register/getCharge";
			axios.post(url).then(resp => {
				this.chargeList = resp.data.data;
			})
		},
		methods: {
			add() {
				this.$refs["loginForm"].validate(valid => {
					if (valid) {
						if (this.addList.isbook) {
							this.addList.isbook = '1';
						} else {
							this.addList.isbook = '0';
						}
						// console.log(this.addList);

						let user = this.$getSessionStorage("user");

						this.addList.user2.id = user.id;

						this.addList.visitstate = 1;

						let url = "register/insert";

						axios.post(url, this.addList).then(resp => {
							if (resp.data.data == 1) {
								alert("cg");
								this.$refs["loginForm"].resetFields();
							}
						})
					}
				});


			},
			/* getByA(){
				let url = "register/getByA";
				axios.post(url,`noon=${this.addList.noon}&deptId=${this.addList.department.id}`).then(resp=>{
					this.doctorList = resp.data.data;
					console.log(this.doctorList);
				})
			} */
			getByDate() {
				this.addList.noon = '';
				this.addList.department.id = '';
				this.addList.registlevel.id = '';
				this.addList.user1.id = '';

				let url = "register/getByDate";
				axios.post(url, `date=${this.addList.visitdate}`).then(resp => {

					this.dateList = resp.data.data;
					// console.log(this.doctorList);
				});
			},
			getDept() {
				this.addList.registlevel.id = '';
				this.addList.user1.id = '';
				let url = "register/getByDateAndNoon";
				axios.post(url, `date=${this.addList.visitdate}&noon=${this.addList.noon}`).then(resp => {


					this.departmentList = resp.data.data;
					// console.log(this.departmentList);
				});
			},
			getRegistLv() {
				this.addList.registlevel.id = '';
				this.addList.user1.id = '';
				let url = "register/getByDateAndNoonAndDeptId";
				axios.post(url, `date=${this.addList.visitdate}&noon=${this.addList.noon}&deptId=${this.addList.department.id}`).then(
					resp => {
						this.registlevelList = resp.data.data;
						// console.log(this.registlevelList);
					});
			},
			getDoctor() {
				// this.addList.user1.id = '';
				let url = "register/getByDateAndNoonAndDeptIdAndRelId";
				axios.post(url,
					`date=${this.addList.visitdate}&noon=${this.addList.noon}&deptId=${this.addList.department.id}&relId=${this.addList.registlevel.id}`
				).then(resp => {

					this.doctorList = resp.data.data;
					// console.log(this.doctorList);
					// console.log(this.doctorList);
				});
			},
			clearr() {
				this.$refs["loginForm"].resetFields();
				this.price = '';
				this.addList.department.id = '';
				this.addList.registlevel.id = '';
				this.addList.user1.id = '';
			}
		}
	}
</script>

<style>
	.scolor {
		color: red;
	}
</style>
