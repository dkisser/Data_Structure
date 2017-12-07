function login() {
	layui.use('layer', function(){ 
		  var $ = layui.jquery,
		  layer = layui.layer;
	      layer.open({
	        type: 1
	        ,title: false //不显示标题栏
	        ,closeBtn: false
	        ,area: '400px;'
	        ,shade: 0.4
	        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
	        ,btn: ['登录', '取消']
	        ,moveType: 1 //拖拽模式，0或者1
	        ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">你知道吗？亲！<br>layer ≠ layui<br><br>layer只是作为Layui的一个弹层模块，由于其用户基数较大，所以常常会有人以为layui是layerui<br><br>layer虽然已被 Layui 收编为内置的弹层模块，但仍然会作为一个独立组件全力维护、升级。<br><br>我们此后的征途是星辰大海 ^_^</div>'
	        ,success: function(layero){
	          var btn = layero.find('.layui-layer-btn');
	          btn.css('text-align', 'center');
	          btn.find('.layui-layer-btn0').attr({
	            href: 'http://www.layui.com/'
	            ,target: '_blank'
	          });
	        }
	      });
	});
}

function regist() {
	
}

