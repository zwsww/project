<template>
	<div>
		<el-container>
			<el-header>NEWS</el-header>
			<el-container>
				<el-aside>
					<el-menu>
						<template v-for="(menu,index) in menus">
							<template v-if="menu.parentId == 0">
								<el-submenu :index="index+''"  :key="index">								
										<span slot="title">
											<i class="el-icon-menu"></i>{{menu.title}}
										</span>
										<template v-for="(childMenu,childIndex) in menus">
											<template v-if="menu.id == childMenu.parentId">
												<el-menu-item :key="childIndex" @click="addTab(childMenu)">
													{{childMenu.title}}
												</el-menu-item>
											</template>
										</template>
								</el-submenu>
							</template>
						</template>
					</el-menu>
					
				</el-aside>
				<el-main>
					<el-tabs type="card" closable @tab-remove="handleRemove" v-model="activeName" @tab-click="handleClick">
						<el-tab-pane v-for="(item,index) in editableTabs" :label="item.title" :name="item.name">
							<component :is="item.componentName"></component>
						</el-tab-pane>
					</el-tabs>
				</el-main>
			</el-container>
			<el-footer>版权：东软睿道</el-footer>
		</el-container>
	</div>
</template>

<script>
	import Vue from 'vue'
	export default{
		data(){
			return{
				user:{},
				menus:[],
				activeName:'b',
				editableTabs:[
				],
			}
		},
		created(){
			this.user = this.$getSessionStorage("user");
			
			let url = "role/getMenuByRoleId";
			/* axios.post(url,`roleId=${this.user.role.id}`).then(resp=>{ */
			axios.post(url,`roleId=7`).then(resp=>{
				this.menus = resp.data.data;
			});
		},
		methods:{
			handleClick(tab,event){
				console.log(tab,event);
			},
			addTab(menu){
				let newTabName = menu.id+'';
				let b = this.editableTabs.some(tab=>tab.name == newTabName);
				
				
				if(!b){
					this.editableTabs.push({
						title:menu.title,
						name:newTabName,
						componentName:'com'+newTabName
					});
				}
				
				Vue.component('com'+newTabName,()=>import('@/views/'+menu.url+'.vue'));
				this.activeName = newTabName;
			},
			handleRemove(targetName){
				let temp = this.activeName;
				if(this.activeName === targetName){
					this.editableTabs.forEach((tab,index)=>{
						if(tab.name === this.activeName){
							let nextTab = this.editableTabs[index+1] || this.editableTabs[index-1];
							if(nextTab){
								temp = nextTab.name;
							}
						}
					})
				}
				
				this.activeName = temp;
				this.editableTabs = this.editableTabs.filter(tab=>tab.name !== targetName);
			},
		}
	}
</script>

<style scoped="scoped">		
	.el-header,.el-footer{
		height: 100px;
		background-color: #409EFF;
	}
	.el-aside{
		height: 600px;
	}
	.link{
		text-decoration: none;
	}
</style>
