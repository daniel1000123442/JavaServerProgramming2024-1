	function calcjs(){
		let n1 = parseFloat(document.getElementById("n1").value);
		let n2 = parseFloat(document.getElementById("n2").value);
		let op = document.getElementById("op").value;
		let ans = document.getElementById("ans");
		
		switch(op){
			case "+": result = n1 + n2; break;
			case "-": result = n1 - n2; break;
			case "*": result = n1 * n2; break;
			case "/": result = n1 / n2; break;
		}
		
		ans.value = result;
	}