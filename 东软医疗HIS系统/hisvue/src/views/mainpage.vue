<template>
	<div>
		<el-container>
			<el-header>
				<el-row>
					<el-col :span="21">
						<span class="main_title">东软医疗HIS系统</span>
					</el-col>
					<el-col :span="2" :offset="1">
							<el-dropdown @command="handleCommand" class="el-dropdown-link">
								<span class="user_title">
									{{username}}<i class="el-icon-arrow-down el-icon--right"></i>
								</span>
								<el-dropdown-menu slot="dropdown">
									<el-dropdown-item command="hideMenu">
										{{menuText}}
									</el-dropdown-item>
									<el-dropdown-item divided command="exit">
										退出登录
									</el-dropdown-item>
								</el-dropdown-menu>
							</el-dropdown>
					</el-col>
				</el-row>
			</el-header>
			<el-container class="a">
				<el-aside v-show="menuText=='隐藏菜单'">
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
				menuText:'隐藏菜单'
			}
		},
		computed:{
			username(){
				return this.$getSessionStorage('user').username.toUpperCase();
			}
		},
		created(){
			this.user = this.$getSessionStorage("user");
			
			let url = "role/getMenuByRoleId";
			axios.post(url,`roleId=${this.user.role.id}`).then(resp=>{
			/* axios.post(url,`roleId=7`).then(resp=>{ */
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
			handleCommand(command){
				if(command == "hideMenu"){
					if(this.menuText == "隐藏菜单"){
						
						this.menuText = "显示菜单";
					}else{
						this.menuText = "隐藏菜单"
					}
				}else if(command == "exit"){
					this.$confirm("你想好了吗？","提示").then(()=>{
						this.$router.push("/login");
						sessionStorage.clear();
					}).catch(()=>{});
				}
			}
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
	.main_title{
		font-size: 1.375rem;
		color: #fff;
		height: 60px;
		line-height: 60px;
	}
	.user_title{
		font-size: 16px;
		color: #FFFFFF;
		height: 60px;
		line-height: 60px;
	}
	.a{
		height: 600px;
	}
	.el-dropdown-link{
		cursor: pointer;
	}
</style>
