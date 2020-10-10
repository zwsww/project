<template>
	<div>
		<el-form :inline="true" size="mini">
			<el-form-item>
				<el-input placeholder="请输入科室编号或名称"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary">查询科室</el-button>
			</el-form-item>
			<el-form-item>
				<el-button type="primary">新增科室</el-button>
			</el-form-item>
		</el-form>
		<el-table  :data="pageInfo.list">
			<el-table-column type="selection"> </el-table-column>
			<el-table-column label="科室编号" width="100" prop="id"> </el-table-column>
			<el-table-column label="科室名称" width="100" prop="deptname"> </el-table-column>
			<el-table-column label="科室分类" width="100" prop="deptCategory.name"> </el-table-column>
			<el-table-column label="科室类型" width="100" prop="depttype"> </el-table-column>
			<el-table-column label="操作" width="200"> 
				<el-button type="primary" size="mini">编辑</el-button>
				<el-button type="danger" size="mini">删除</el-button>
			</el-table-column>
		</el-table>
		<el-form :inline="true" size="mini" style="padding-left:55px;">
			<el-form-item>
				<el-button type="danger" :disabled="true">批量删除</el-button>
			</el-form-item>
			<el-form-item style="padding-left: 100px;">
				<el-pagination
					layout="prev,pager,next"
					background
				></el-pagination>
			</el-form-item>
		</el-form>
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
				disableItemDialog: false,
				typelist: [],
				params: {},
				itemPageInfo: {},
				ids:[]
			}
		},
		created() {
				this.showData(1,this.pageInfo.pageSize, this.keyword);
		},
		methods: {
			showData(pageNum,pageSize,keyword){
				let url = "DepartMent/getPaged";
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
