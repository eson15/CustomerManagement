
function pageInit(){
	makeYear();
	makeMonth();
	makeDay();
}

function makeYear(){
	var year = document.getElementById("year");
	var current = new Date().getFullYear();
	for(var i = 1901; i <= current; i ++){	
		var option = document.createElement("option");
		option.value = i;
		option.innerHTML = i;
		year.appendChild(option); //将option挂在select下
	}
}

function makeMonth() {
	var month = document.getElementById("month");
	for(var i = 2; i <= 12; i ++){
		var option = document.createElement("option");
		if(i < 10) {
			option.value = '0' + i;
			option.innerHTML = '0' + i;
		}
		else {
			option.value = i;
			option.innerHTML = i;
		}	
		month.appendChild(option);
	}
}

function makeDay() {//简单的默认为31了
	var day = document.getElementById("day");
	for(var i = 2; i <= 31; i ++){
		var option = document.createElement("option");
		if(i < 10) {
			option.value = '0' + i;
			option.innerHTML = '0' + i;
		}
		else {
			option.value = i;
			option.innerHTML = i;
		}	
		day.appendChild(option);
	}
}

function doSubmit(){
	makePreference();
	makeBirthday();
	return;
}

function makeBirthday(){
	
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	var day = document.getElementById("day").value;
	var birthday = year + "-" + month + "-" + day;
	var input = document.createElement("input"); //新建一个隐藏标签挂到select下
	input.type = "hidden";
	input.name = "birthday";
	input.value = birthday;
	document.getElementById("customer").appendChild(input);
}

function makePreference() {
	var likes = "";
	var pres = document.getElementsByName("like");
	for(var i = 0; i < pres.length; i++) {
		if(pres[i].checked == true){
			likes = likes + pres[i].value + ",";
		}
	}
	likes = likes.substr(0, likes.length-1);//删掉最后一个逗号
	
	var input = document.createElement("input");
	input.type = "hidden";
	input.name = "likes";
	input.value = likes;
	
	document.getElementById("customer").appendChild(input);
}