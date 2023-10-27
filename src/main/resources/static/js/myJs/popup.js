$(function(){

    // 판매자 정보 팝업 띄우기
    $('.orderItem .company > a').click(function(e){
        e.preventDefault();
        $('#popSeller').addClass('on');
    });

    // 문의하기 팝업 띄우기
    $('.btnQuestion').click(function(e){
        e.preventDefault();
        $('.popup').removeClass('on');
        $('#popQuestion').addClass('on');
    });

    // 주문상세 팝업 띄우기
    $('.orderInfo .orderNo > a').click(function(e){
        e.preventDefault();

        const tr 		             = $(this).parent().parent(); // .orderInfo
        const ordNo	         = tr.find('.orderNo').find('.ordNo').text();
        const date 		     = tr.find('.date').text();
        const status 		 = tr.find('.status').text();
        const ordName 		 = tr.find('.ordName').text();
        const recipName 		 = tr.find('.recipName').text();
        const recipHp 		 = tr.find('.recipHp').text();
        const recipAddress 		 = tr.find('.recipAddress').text();

        let selectedTR = tr.next(); //.orderItem
        let isItem = true;
        while(isItem){

            alert('dd');
            if(selectedTR.className !== 'orderItem'){
                isItem = false;
            }
            selectedTR = selectedTR.next();
        }

        const popup = $('#popOrder');
        popup.find('.ordNo').text(ordNo);
        popup.find('.date').text(date);
        popup.find('.status').text(status);
        popup.find('.ordName').text(ordName);
        popup.find('.recipName').text(recipName);
        popup.find('.recipHp').text(recipHp);
        popup.find('.recipAddress').text(recipAddress);
        /*
        if(thumb1 == 'soldOut'){
            popup.find('.thumb > img').attr("src", "/Farmstory2/admin/images/soldOut.png");
        } else {
            popup.find('.thumb > img').attr("src", "/Farmstory2/thumb/"+thumb1);
        }
        popup.find('.thumb > img').attr("alt", pName);
        */

        popup.addClass('on');
    });

    // 수취확인 팝업 띄우기
    $('.orderItem .confirm > .receive').click(function(e){
        e.preventDefault();
        $('#popReceive').addClass('on');
    });

    // 상품평 작성 팝업 띄우기
    $('.orderItem .confirm > .review').click(function(e){
        e.preventDefault();
        $('#popReview').addClass('on');
    });
               
    // 팝업 닫기
    $('.btnClose').click(function(){                
        $(this).closest('.popup').removeClass('on');                
    });

    // 상품평 작성 레이팅바 기능
    $(".my-rating").starRating({
        starSize: 20,
        useFullStars: true,
        strokeWidth: 0,
        useGradient: false,
        minRating: 1,
        ratedColors: ['#ffa400', '#ffa400', '#ffa400', '#ffa400', '#ffa400'],
        callback: function(currentRating, $el){
            alert('rated ' + currentRating);
            console.log('DOM element ', $el);
        }
    });

});