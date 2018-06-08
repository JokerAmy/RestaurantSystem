window.onload = function()
{
	var trs = document.getElementsByTagName("tr");
	for(var i=1; i < trs.length; i++)
	{
		trs[i].setAttribute("class", "hover");
	}
}