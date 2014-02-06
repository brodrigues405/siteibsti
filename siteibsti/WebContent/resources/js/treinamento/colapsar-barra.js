var lock = 0;
var lock1 = 0;
var lock2 = 0;

$(function(){
	$(".treinamento-exp").click(function() {
		$(".esconder-dev1").slideToggle();

		if(lock == 0) {
			$(".seta").addClass("seta-pra-baixo");
			lock = 1;
		}
		else {
			$(".seta").removeClass("seta-pra-baixo");			
			lock = 0;
		}
	});


	$(".treinamento-ana").click(function() {
		$(".esconder-ana1").slideToggle();
		
		if(lock == 0) {
			$(".seta1").addClass("seta-pra-baixo");
			lock = 1;
		}
		else {
			$(".seta1").removeClass("seta-pra-baixo");			
			lock = 0;
		}
	});

	$(".treinamento-val").click(function() {
		$(".esconder-val1").slideToggle();
		
		if(lock == 0) {
			$(".seta2").addClass("seta-pra-baixo");
			lock = 1;
		}
		else {
			$(".seta2").removeClass("seta-pra-baixo");			
			lock = 0;
		}
	});
});