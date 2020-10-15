<template>
	<div>
		患者信息查询
		<br>
		<el-form size="mini">
			<el-row>
				<el-col :span="4">
					<el-form-item >
						<span class="scolor">*</span> 病 历 号：
						<el-input style="width: 100px;" placeholder="输入病例号" v-model="registid"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="4">
					<el-form-item >
						<el-button type="primary" @click="selregist()">搜索</el-button>
					</el-form-item>
				</el-col>
			</el-row>
			
			患者信息确认
			<el-row>
				<el-col :span="4">
					<el-form-item>
						姓 名：
						<el-input style="width: 100px;" v-model="regist.realname" readonly></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="6">
					<el-form-item>
						身份证号：
						<el-input style="width: 200px;" v-model="regist.idnumber" readonly></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item>
						家庭住址：
						<el-input style="width: 300px;" v-model="regist.homeaddress" readonly></el-input>
					</el-form-item>
				</el-col>
			</el-row>
		</el-form>
		
		患者挂号信息
		<el-table :data="registList.list" style="100%">
			<el-table-column label="病历号" prop="casenumber" width="80"></el-table-column>
			<el-table-column label="姓名" prop="realname" width="150"></el-table-column>
			<el-table-column label="身份证号" prop="idnumber" width="150"></el-table-column>
			<el-table-column label="挂号日期" prop="registtime" width="160"></el-table-column>
			<el-table-column label="挂号午别" prop="noon" width="150"></el-table-column>
			<el-table-column label="看诊科室" prop="department.deptname" width="150"></el-table-column>
			<el-table-column label="看诊状态" prop="visitstate" width="150">
				
			</el-table-column>
			<el-table-column label="操作" width="150">
				<el-button size="mini" type="primary" @click="tui()">退号</el-button>
			</el-table-column>
		</el-table>
		
	</div>
</template>

<script>
	export default{
		data(){
			return{
				registList:{
					list:[]
				},
				registid:'',
				regist:{}
			}
		},
		created() {
			
		},
		methods:{
			selregist(){
				let url = "register/getByCaseNumber";
				axios.post(url,`num=${this.registid}`).then(resp=>{
					this.registList.list = resp.data.data;
					
					if(this.registList.list[0].visitstate == 1){
						this.registList.list[0].visitstate = '已挂号'
					}else if(this.registList.list[0].visitstate == 2){
						this.registList.list[0].visitstate = '医生接诊'
					}else if(this.registList.list[0].visitstate == 3){
						this.registList.list[0].visitstate = '看诊结束'
					}else if(this.registList.list[0].visitstate == 4){
						this.registList.list[0]	.visitstate = '已退号'
					}
					
					this.regist = resp.data.data[0];	
				})
			},
			tui(){
				let url = "register/updataVisitState";
				axios.post(url,`id=${this.regist.id}&visitstate=4`).then(resp=>{
					if(resp.data.data == 1){
						alert("已退号");
						this.selregist();
					}	
				});
			}
		}
	}
</script>

<style>
	.scolor{
		color: red;
	}
</style>
