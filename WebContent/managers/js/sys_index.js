window.onload = function()
{
	var lis = document.getElementsByTagName("li");
	var topBar = document.getElementById("topBar");
	// 定义存放标题名称的节点的数组的全局变量
	topBar_childs = [];
	// 定义了全局变量并赋值
	iframe = document.getElementById("right");
	// 定义了一个全局变量数组记录添加的标题条的名称
	topBarNames = [];
	
	for(var i=0; i < lis.length; i++)
	{ // 添加hover效果
		lis[i].setAttribute("class", "hover");
	}
	
	// 添加点击的页面跳转效果
	lis[0].onclick = function()
	{
		iframe.src ="foodController?type=displayBreakfast";
		// 添加菜单条asd
		addTopBar("早餐管理");
	}
	lis[1].onclick = function()
	{
		iframe.src = "foodController?type=displayLunch";
		// 添加菜单条
		addTopBar("午餐管理");
	}
	lis[2].onclick = function(){
		iframe.src = "foodController?type=displayDinner";
		// 添加菜单条
		addTopBar("晚餐管理");
	}
	lis[3].onclick = function()
	{
		iframe.src = "sys/MVServlet?type=display";
		// 添加菜单条
		addTopBar("会员管理");
	}
	lis[4].onclick=function()
	{
		addTopBar("酒水管理");
		iframe.src="foodController?type=displayWine";
		
	}
	
	
	
	// 添加菜单条
	function addTopBar(titleName)
	{
		// 将之前的标题条的id全设为noselected
		for(var i=0; i<topBar_childs.length; i++)
		{
			topBar_childs[i].setAttribute("id", "noselected");
		}
		
		// 删除相同标题条
		for(var i=0; i<topBar_childs.length; i++)
		{
			var innerHTML = topBar_childs[i].innerHTML;	
			if(innerHTML.indexOf(titleName) > 0)
			{
				// 如果标题条相同，则删除
				topBar.removeChild(topBar_childs[i]);
				topBar_childs.splice(i, 1);
				// 删除记录标题条在记录标题条名称数组中的记录
				for(var j=0; j<topBarNames.length; j++)
				{
					if(topBarNames[j] == titleName)
					{
						topBarNames.splice(j, 1);
					}
				}
			}
		}
		// 创建元素
		var topBar_child = document.createElement("div");
		topBar_child.setAttribute("id", "selected");
		// 添加元素形成标题 span 与 第二个img 设置了点击事件,分别对应跳转函数和删除标题条事件
		topBar_child.innerHTML ='<span onclick=into("'+titleName+'")>'+titleName+'</span><img onclick=deleteTopBar("'+titleName+'") src="managers/images/closeButtom.png" />';
		// 将div添加到topBar中
		topBar.appendChild(topBar_child);
		// 同时将它添加到数组里
		topBar_childs.push(topBar_child);
		// 记录最后一个标签条的名字
		topBarNames.push(titleName);
	}	
}

//删除菜单条
function deleteTopBar(titleName)
{
	// 遍历数组是得到当前要删除的标题条
	for(var i=0; i<topBar_childs.length; i++)
	{
		// 记录当前index
		index = i;
		var innerHTML = topBar_childs[i].innerHTML;
		if(innerHTML.indexOf(titleName) > 0)
		{
			// 如果得到该标题条，则删除
			topBar.removeChild(topBar_childs[i]);
			topBar_childs.splice(i, 1);
			// 删除记录标题条在记录标题条名称数组中的记录
			for(var j=0; j<topBarNames.length; j++)
			{
				if(topBarNames[j] == titleName)
				{
					topBarNames.splice(j, 1);
				}
			}
			// 页面转向titleName数组最后一个元素即标题条名称所对应的页面
			if(topBarNames.length > 0)
			{
				// 如果页面还存在标题条， 则跳转到最后一个标题条所对应的页面
				into(topBarNames[topBarNames.length-1]);
			}else
			{
				// 如果页面不存在标题条， 则跳转到空页面
				into('');
			}
		}
	}

}

// 点击菜单条跳转到相应页面
function into(titleName)
{
	if(titleName == "早餐管理")
	{
		iframe.src = "foodController?type=displayBreakfast";
	}
	else if(titleName == "午餐管理")
	{
		iframe.src = "foodController?type=displayLunch";
	}else if(titleName == "晚餐管理")
	{
		iframe.src = "foodController?type=displayDinner";
	}else if(titleName == "MV管理")
	{
		iframe.src = "sys/MVServlet?type=display";
	}
	else if(titleName=="酒水管理")
	{
		iframe.src = "foodController?type=displayWine";
		
	}
	
	else
	{
		iframe.src = '';
	}
	// 遍历标题条数组
	for(var i=0; i<topBar_childs.length; i++){
		var innerHTML = topBar_childs[i].innerHTML;
		if(innerHTML.indexOf(titleName) > 0){
			// 将跳转到的目标标题条的id设为selected
			topBar_childs[i].setAttribute("id", "selected");
		}else{
			// 将其余的标题条的id设为noselected
			topBar_childs[i].setAttribute("id", "noselected");
		}
	}
}

