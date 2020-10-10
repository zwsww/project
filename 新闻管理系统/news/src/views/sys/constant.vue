<template>
	<div>
		<el-form :inline="true" size="mini">
			<el-form-item>
				<el-input v-model="keyword" placeholder="请输入常量类别编码和名称"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="search">查询常量类别</el-button>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="disableAddTypeDialog = true">新增常量类别</el-button>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="disableEditTypeDialog = true">常数项管理</el-button>
			</el-form-item>
		</el-form>
		<el-table :data="pageInfo.list" style="100%">
			<el-table-column label="编号" prop="id" width="80"></el-table-column>
			<el-table-column label="代码" width="200">
				<template slot-scope="scope">
					<template v-if="scope.row.edit">
						<el-input v-model="type.constanttypecode" size="mini"></el-input>
					</template>
					<template v-else>
						<span>{{scope.row.constanttypecode}}</span>
					</template>
				</template>
			</el-table-column>
			<el-table-column label="名称" width="120">
				<template slot-scope="scope">
					<template v-if="scope.row.edit">
						<el-input v-model="type.constanttypename" size="mini"></el-input>
					</template>
					<template v-else>
						<span>{{scope.row.constanttypename}}</span>
					</template>
				</template>
			</el-table-column>
			<el-table-column label="操作" width="180">
				<template slot-scope="scope">
					<template v-if="scope.row.edit">
						<el-button @click="handleTypeSave(scope)" size="mini" type="primary">保存</el-button>
						<el-button size="mini" @click="scope.row.edit=false" type="danger">取消</el-button>
					</template>
					<template v-else>
						<el-button @click="handleTypeEdit(scope)" size="mini" type="primary">编辑</el-button>
						<el-button size="mini" @click="handleTypeDel(scope)" type="danger">删除</el-button>
					</template>
				</template>
			</el-table-column>
		</el-table>
		<el-pagination layout="prev,pager,next,total,jumper,sizes" :total="pageInfo.total" :page-size="pageInfo.pageSize"
		 :page-count="pageInfo.navigatePages" :page-sizes="[5,10,15,20]" :current-page="pageInfo.pageNum" background
		 @current-change="handleCurrentChange" @size-change="handleSizeChange"></el-pagination>

		<el-dialog :visible.sync="disableAddTypeDialog" title="新增常数类别" center>
			<el-form :inline="true" align="center" size="mini">
				<el-form-item label="常数类别编码:">
					<el-input v-model="type.constanttypecode" placeholder="常数类别编码"></el-input>
				</el-form-item>
				<el-form-item label="常数类别名称:">
					<el-input v-model="type.constanttypename" placeholder="常数类别名称"></el-input>
				</el-form-item>
				<el-form-item>
					<el-button @click="handleInsert()" type="primary">保存</el-button>
					<el-button type="danger" @click="disableAddTypeDialog=false">取消</el-button>
				</el-form-item>
			</el-form>
		</el-dialog>
		<el-dialog :visible.sync="disableEditTypeDialog" title="常数项列表" center>
			<el-form :inline="true" align="center" size="mini">
				<el-form-item>
					<el-input placeholder="请输入常量类别编码和名称" v-model="keyword"></el-input>
				</el-form-item>
				<el-form-item>
					<template>
						<el-select placeholder="所属分类">
							<el-option>
							</el-option>
						</el-select>
					</template>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="getAll()">查询常量类别</el-button>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="disableAddTypeDialog = true">新增常量类别</el-button>
				</el-form-item>
			</el-form>
			<hr />
			<el-table>
				<el-table-column>
					
				</el-table-column>
				<el-table-column label="编码" width="80">
				</el-table-column>
				<el-table-column label="名称" width="200">
				</el-table-column>
				<el-table-column label="类别" width="120">
				</el-table-column>
				<el-table-column label="ID" width="120">
				</el-table-column>
				<el-table-column label="操作" width="180">
				</el-table-column>
			</el-table>
			<br>
			<el-form style="text-align: center;">
				<el-form-item>
					<el-button type="danger">批量删除</el-button>
					<el-button @click="disableEditTypeDialog = false">关闭</el-button>
				</el-form-item>
			</el-form>
		</el-dialog>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				pageInfo: {
					pageNum: 1,
					pageSize: 5
				},
				keyword: "",
				type: {},
				disableAddTypeDialog: false,
				disableEditTypeDialog: false,
				checkd:[]
			}
		},
		created() {
			this.showData(1, this.pageInfo.pageSize, this.keyword)
		},
		methods: {
			showData(pageNum, pageSize, keyword) {
				let url = "constantType/getPaged";
				let params = `pageNum=${pageNum}&pageSize=${pageSize}&keyword=${keyword}`;
				axios.post(url, params).then(resp => {
					this.pageInfo = resp.data.data;
				});
			},
			handleCurrentChange(pageNum) {
				this.showData(pageNum, this.pageInfo.pageSize, this.keyword);

			},
			handleSizeChange(pageSize) {
				this.showData(1, pageSize, this.keyword);
				this.pageInfo.pageSize = pageSize;
			},
			search() {
				this.showData(1, this.pageInfo.pageSize, this.keyword)
			},
			handleTypeEdit(scope) {
				this.$set(scope.row, "edit", true);
				this.type = { ...scope.row
				}
			},
			handleTypeSave(scope) {
				let url = "constantType/update";
				axios.post(url, this.type).then(resp => {
					if (resp.data.data == 1) {
						this.showData(this.pageInfo.pageNum, this.pageInfo.pageSize, this.keyword);
					}
				});
			},
			handleTypeDel(scope) {
				this.$confirm("是否删除？", "提示").then(() => {
					let url = "constantType/delete";
					axios.post(url, `id=${scope.row.id}`).then(resp => {
						if (resp.data.data == 1) {
							this.$alert("删除成功！");
							this.showData(this.pageInfo.pageNum, this.pageInfo.pageSize, this.keyword);
						}
					});
				}).catch(err => {
					console.log(err)
				});
			},
			handleInsert() {
				let url = "constantType/insert";
				axios.post(url, this.type).then(resp => {
					if (resp.data.data == 1) {
						this.showData(this.pageInfo.navigateLastPage, this.pageInfo.pageSize, this.keyword);
						this.disableAddTypeDialog = false;
					}
				});
				this.type = {};
			},
			getAll() {
				let url = "constantType/getAll";
				let params = `pageNum=${pageNum}&pageSize=${pageSize}&keyword=${keyword}`;
				axios.post(url, params).then(resp => {
					this.pageInfo = resp.data.data;
				});
			}
		}
	}
</script>

<style>
</style>
