<template>
	<div>
		<el-form :inline="true" size="mini">
			<el-form-item>
				<el-input v-model="keyword" placeholder="请输入科室编号或名称"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="search()">查询科室</el-button>
				<el-button type="primary" @click="handleDepartmentAdd()">新增科室</el-button>
			</el-form-item>
		</el-form>
		<el-table :data="pageInfo.list"  @selection-change="handleSelectionChange">
			<el-table-column type="selection"></el-table-column>
			<el-table-column label="科室编号" width="120" prop="id"></el-table-column>
			<el-table-column label="科室编码" width="120" prop="deptcode" ></el-table-column>
			<el-table-column label="科室名称" width="120" prop="deptname"></el-table-column>
			<el-table-column label="科室分类" width="120" prop="deptcategory.name"></el-table-column>
			<el-table-column label="科室类型" width="120" prop="depttype"></el-table-column>
			<el-table-column label="操作" width="200">
				<template slot-scope="scope">
						<el-button type="primary" @click="handleDepartmentEdit(scope)" size="mini">编辑</el-button>
						<el-button type="danger" size="mini" @click="handleDepartmentDel(scope)">删除</el-button>
				</template>
			</el-table-column>
		</el-table>
		<el-form :inline="true" size="mini">
			<el-form-item style="padding-left: 100px;">
				<el-button type="danger" size="mini" :disabled="ids.length==0" @click="batchDelete">批量删除</el-button>
			</el-form-item>
			<el-form-item style="padding-left: 120px;">
				<el-pagination
				 :total="pageInfo.total"
				 :page-count="pageInfo.nevigatePages"
				 :page-size="pageInfo.pageSize"
				 :current-page="pageInfo.pageNum"
				 layout="prev,pager,next"
				 background
				 @current-change="handleCurrentChange"
				 @size-change="handleSizeChange"></el-pagination>
			</el-form-item>
			</el-form>
			<el-dialog :visible.sync="xzks" title="新增科室" center>
				<el-form :inline="true" align="center" size="mini" width="500px">
					<el-row>
						<el-col :span="12">
							<el-form-item label="科室编码:" label-width="80px">
								<el-input v-model="addtype.deptcode" placeholder="科室编码" style="width:120px;"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item label="科室名称:" label-width="80px">
								<el-input v-model="addtype.deptname" placeholder="科室名称" style="width:120px;"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="12">
							<el-form-item  label="科室分类:" label-width="80px">
							<el-select style="width:120px;" placeholder="所属分类" v-model="addtype.deptcategory.id">
								<el-option
									v-for="list in typeList"
									:key="list.id"
									:label="list.name"
									:value="list.id"
								>
									
								</el-option>
							</el-select>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item  label="科室类别:" label-width="80px">
							<el-select style="width:120px;" placeholder="所属分类"  v-model="addtype.depttype">
								<el-option label="临床" value="1">临床</el-option>
								<el-option label="医技" value="2">医技</el-option>
								<el-option label="财务" value="3">财务</el-option>
								<el-option label="行政" value="4">行政</el-option>
								<el-option label="其他" value="5">其他</el-option>
							</el-select>
							</el-form-item>
						</el-col>
					</el-row>
					
					<el-form-item>
						<el-button type="primary" @click="insertType()">保存</el-button>
						<el-button type="warning" @click="xzks=false">取消</el-button>
					</el-form-item>
				</el-form>
			</el-dialog>
			<el-dialog :visible.sync="bjks" title="编辑科室" center>
				<el-form :inline="true" align="center" size="mini" width="500px">
					<el-row>
						<el-col :span="12">
							<el-form-item label="科室编码:" label-width="80px">
								<el-input v-model="type.deptcode" style="width:120px;"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item label="科室名称:" label-width="80px">
								<el-input v-model="type.deptname" style="width:120px;"></el-input>
							</el-form-item>
						</el-col>
					</el-row>
					<el-row>
						<el-col :span="12">
							<el-form-item  label="科室分类:" label-width="80px">
							<el-select style="width:120px;" v-model="type.deptcategory.id">
								<el-option
									v-for="list in typeList"
									:key="list.id"
									:label="list.name"
									:value="list.id"
								>
									
								</el-option>
							</el-select>
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item  label="科室类别:" label-width="80px">
							<el-select style="width:120px;" v-model="type.depttype">
								<el-option label="临床" value="1">临床</el-option>
								<el-option label="医技" value="2">医技</el-option>
								<el-option label="财务" value="3">财务</el-option>
								<el-option label="行政" value="4">行政</el-option>
								<el-option label="其他" value="5">其他</el-option>
							</el-select>
							</el-form-item>
						</el-col>
					</el-row>
					
					<el-form-item>
						<el-button type="primary" @click="updateType()">保存</el-button>
						<el-button type="warning" @click="bjks=false">取消</el-button>
					</el-form-item>
				</el-form>
			</el-dialog>
	</div>


</template>

<script>
	export default{
		data(){
			return{
				pageInfo:{
					pageNum:1,
					pageSize:5,
				
				},
				keyword:"",
				type:{
					deptcode:'',
					deptname:'',
					deptcategory:{}
				},
				xzks:false,
				bjks:false,
				typeList:[],
				addtype:{
					// deptcode:'',
					// deptname:'',
					deptcategory:{},
					delmark:1
				},
				ids:[]
			}
		},
		created(){
			this.showData(1,this.pageInfo.pageSize,this.keyword);
		},
		methods:{
			showData(pageNum,pageSize,keyword){
				let url = "department/getPaged";
				let params = `pageNum=${pageNum}&pageSize=${pageSize}&keyword=${keyword}`;
				axios.post(url,params).then(resp=>{
					this.pageInfo = resp.data.data;
					
					for(let i = 0;i<this.pageInfo.list.length;i++){
						if(this.pageInfo.list[i].depttype == 1){
							this.pageInfo.list[i].depttype = "临床"
						}else if(this.pageInfo.list[i].depttype == 2){
							this.pageInfo.list[i].depttype = "医技"
						}else if(this.pageInfo.list[i].depttype == 3){
							this.pageInfo.list[i].depttype = "财务"
						}else if(this.pageInfo.list[i].depttype == 4){
							this.pageInfo.list[i].depttype = "行政"
						}else if(this.pageInfo.list[i].depttype == 5){
							this.pageInfo.list[i].depttype = "其他"
						}
					}
					 
					
				});
			},
			handleCurrentChange(pageNum){
				this.showData(pageNum,this.pageInfo.pageSize,this.keyword);
			},
			handleSizeChange(pageSize){
				this.showData(1,pageSize,this.keyword);
				this.pageInfo.pageSize = pageSize;
			},
			search(){
				this.showData(1,this.pageInfo.pageSize,this.keyword);
			},
			handleDepartmentEdit(scope){
			this.bjks = true;
			this.type = scope.row;
			console.log(scope.row);
			let url = "constantItem/getAll";
			axios.post(url,`id=${1}`).then(resp=>{
				this.typeList = resp.data.data;
				// console.log(this.typeList);
			});
			},
			updateType(scope){
				if(this.type.depttype == "临床"){
					this.type.depttype = 1;
				}else if(this.type.depttype == "医技"){
					this.type.depttype = 2;
				}else if(this.type.depttype == "财务"){
					this.type.depttype = 3;
				}else if(this.type.depttype == "行政"){
					this.type.depttype = 4;
				}else if(this.type.depttype == "其它"){
					this.type.depttype = 5;
				}
				let url = "department/update";
				console.log(this.type);
				axios.post(url,this.type).then(resp=>{
					if(resp.data.data == 1){
					this.showData(1,this.pageInfo.pageSize,this.keyword);
					this.bjks=false;
						
					}
				});
			},
			handleDepartmentDel(scope){
				this.$confirm("是否删除","提示").then(()=>{
					let url = "department/delete";
					axios.post(url,`id=${scope.row.id}`).then(resp=>{
						if(resp.data.data ==1){
							this.$alert("删除成功！");
							this.showData(1,this.pageInfo.pageSize,this.keyword)
						}
					});
				}).catch(err=>console.log(err));
				
			},
			handleDepartmentAdd(){
				this.xzks = true;
				
				let url = "constantItem/getAll";
				axios.post(url,`id=${1}`).then(resp=>{
					this.typeList = resp.data.data;
					// console.log(this.typeList);
				});
			},
			insertType(){
				let url = "department/insert";
				axios.post(url,this.addtype).then(resp=>{
					if(resp.data.data ==1){
					//	console.log(addtype);
						this.showData(1,this.pageInfo.pageSize,this.keyword);
						this.xzks=false;
					} 
				});
			},
			handleSelectionChange(item){
				this.ids = item.map(o=>o.id);
			},
			batchDelete(){
				this.$confirm("是否删除？","提示").then(()=>{
					let url = "department/batchDelete";
					axios.post(url,this.ids).then(resp=>{
						if(resp.data.data > 0){
							this.$alert("删除成功！");
							this.showData(1,this.pageInfo.pageSize,this.keyword);
						}
					});
				}).catch(err=>{
					this.$alert(err);
				});
				
			}
			
		}
	}
</script>

<style>
</style>
