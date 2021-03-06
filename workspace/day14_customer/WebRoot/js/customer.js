function pageInit() {
	makeYear();
	makeMonth();
	makeDay();
}
function makeYear() {
	var year = document.getElementById("year");
	for (var i = 1901; i <= new Date().getFullYear(); i++) {
		var option = document.createElement("option");
		option.value = i;
		option.textContent = i;
		year.appendChild(option);
	}
}
function makeMonth() {
	var month = document.getElementById("month");
	for (var i = 2; i <= 12; i++) {
		var option = document.createElement("option");
		if (i < 10) {
			option.value = '0' + i;
			option.textContent = '0' + i;
		} else {
			option.value = i;
			option.textContent = i;
		}
		month.appendChild(option);
	}
}
function makeDay() {
	var month = document.getElementById("month");
	for (var i = 2; i <= 31; i++) {
		var option = document.createElement("option");
		if (i < 10) {
			option.value = '0' + i;
			option.textContent = '0' + i;
		} else {
			option.value = i;
			option.textContent = i;
		}
		day.appendChild(option);
	}
}
function dosubmit() {
	makeBirthday();
	makePreference();
	return true;
}
function makeBirthday() {
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	var day = document.getElementById("day").value;
	var birthday = year + "-" + month + "-" + day;
	var input = document.createElement("input");
	input.type = "hidden";
	input.name = "birthday";
	input.value = birthday;
	document.getElementById("customer").appendChild(input);
}
function makePreference() {
	var preference = "";
	var pres = document.getElementsByName("pre");
	for (var i = 0; i < pres.length; i++) {
		if (pres[i].checked == true) {
			preference = preference + pres[i].value + ",";
		}
	}
	preference = preference.substring(0, preference.length - 1);
	var input = document.createElement("input");
	input.type = "hidden";
	input.name = "preference";
	input.value = preference;
	
	document.getElementById("customer").appendChild(input);
}