(function(){
/*瓦붷썮窈띌깿*/
$(".totop").click(function(){$('body,html').animate({scrollTop: 0 }, 800);})
/*若뚧꽴罌�*/
$(".tabWyq").click(function(){$(".meng").show();$(".tcWyq").fadeIn();resetFn=fixPage();})
$(".tcWyq .tcXx").click(function(){$(".tcWyq").hide();$(".meng").hide();resetFn();})
/*域삣뒯餓뗧퍖*/
$(".tabHdjs").click(function(){$(".meng").show();$(".tcHdjs").fadeIn();resetFn=fixPage();})
$(".tcHdjs .tcXx").click(function(){$(".tcHdjs").hide();$(".meng").hide();resetFn();})
/*�룟룚�닷쩀�잒뒻*/
//$(".jlYhMore").click(function(){$(".meng").show();$(".tcJbcf").fadeIn();resetFn=fixPage();})
//$(".tcJbcf .tcXx").click(function(){$(".tcJbcf").hide();$(".meng").hide();resetFn();})
$(".jlYhMore").click(function(){
	showtcQing("瑥δ뻣�▼컶�ゅ���");
})
/*�싩뵪�숂뎵�녜뿭*/
$(".meng").click(function(){$(".tcTal").hide();$("#toast").hide();$(".meng").hide();resetFn();})

})()