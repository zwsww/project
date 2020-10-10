<template>
	<div>
		<el-table :data="depts" stripe border>
			<el-table-column
				label="部门编号"
				prop="deptno"
			></el-table-column>
			<el-table-column
				label="部门名称"
				prop="dname"
			></el-table-column>
		</el-table>
	</div>
</template>

<script>
	export default{
		data(){
			return{
				depts:[
					{deptno:1,dname:'hr'},
					{deptno:2,dname:'r'},
					{deptno:3,dname:'h'},
				]
			}
		}
	}
</script>

<style>
</style>
