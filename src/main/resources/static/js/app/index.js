var index = {
    init: function(){
        var _this = this;
        $('#btn-save').on('click',function(){
            alert("save button click!");
            _this.save();
        });

        $('#btn-update').on('click',function(){
            alert("update button click!");
            _this.update();
        });

        $('#btn-delete').on('click',function(){
           alert("delete button click!");
           _this.delete();
        });
    },
    save : function(){
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        //var header = $("meta[name='_csrf_header']").attr("content");
        // var token = $("meta[name='_csrf']").attr("content");

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            // beforeSend:function(xhr){
            //     xhr.setRequestHeader(header, token);
            // },
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function(){
        var data = {
            title : $('#title').val(),
            content : $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type : 'PUT',
            url : '/api/v1/posts/'+id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function(){
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        })
    },
    delete : function(){
        var id = $('#id').val();

        $.ajax({
            type : 'DELETE',
            url : '/api/v1/posts/'+id,
            dataType : 'json',
            contentTyep : 'application/json charset=utf-8'
        }).done(function(){
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        })
    }
};

index.init();