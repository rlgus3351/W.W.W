
// 내가 작성한 거 2

var slides2 = document.querySelector('#movie2 .slides'),
    slide2 = document.querySelectorAll('#movie2 .slides li'),
    currentIdx2 = 0,
    slideCount2 = slide2.length,
    slideWidth2 = 515,
    slideMargin2 = 20,
    prevBtn2 = document.querySelector('#movie2 .prev'),
    nextBtn2 = document.querySelector('#movie2 .next');

slides2.style.width = (slideWidth2 + slideMargin2) * slideCount2 - slideMargin2 + 'px';

function moveSlide2(num) {
    slides2.style.left = (slideWidth2 + slideMargin2) * -num + "px";
    currentIdx2 = num;
}
nextBtn2.addEventListener('click', function () {
    if (currentIdx2 < slideCount2 - 3) {
        moveSlide2(currentIdx2 + 1);
    }
});
prevBtn2.addEventListener('click', function () {
    if (currentIdx2 > 0) {
        moveSlide2(currentIdx2 - 1);
    }
});





// 첫번째 3
var slides3 = document.querySelector('#movie3 .slides'),
	slide3 = document.querySelectorAll('#movie3 .slides li'),
	currentIdx3 = 0,
	slideCount3 = slide3.length,
	slideWidth3 = 515,
	slideMargin3 = 20,
	prevBtn3 = document.querySelector('#movie3 .prev'),
	nextBtn3 = document.querySelector('#movie3 .next');

slides3.style.width = (slideWidth3 + slideMargin3) * slideCount3 - slideMargin3 + 'px';

function moveSlide3(num) {
	slides3.style.left = (slideWidth3 + slideMargin3) * -num + "px";
	currentIdx3 = num;
}
nextBtn3.addEventListener('click', function() {
	if (currentIdx3 < slideCount3 - 3) {
		moveSlide3(currentIdx3 + 1);
	}
});
prevBtn3.addEventListener('click', function() {
	if (currentIdx3 > 0) {
		moveSlide3(currentIdx3 - 1);
	}
});



// 두번째 4
var slides4 = document.querySelector('#movie4 .slides'),
    slide4 = document.querySelectorAll('#movie4 .slides li'),
    currentIdx4 = 0,
    slideCount4 = slide4.length,
    slideWidth4 = 515,
    slideMargin4 = 20,
    prevBtn4 = document.querySelector('#movie4 .prev'),
    nextBtn4 = document.querySelector('#movie4 .next');

slides4.style.width = (slideWidth4 + slideMargin4) * slideCount4 - slideMargin4 + 'px';

function moveSlide4(num) {
    slides4.style.left = (slideWidth4 + slideMargin4) * -num + "px";
    currentIdx4 = num;
}
nextBtn4.addEventListener('click', function () {
    if (currentIdx4 < slideCount4 - 3) {
        moveSlide4(currentIdx4 + 1);
    }
});
prevBtn4.addEventListener('click', function () {
    if (currentIdx4 > 0) {
        moveSlide4(currentIdx4 - 1);
    }
});


// 세번째꺼!!!! 5
var slides5 = document.querySelector('#movie5 .slides'),
    slide5 = document.querySelectorAll('#movie5 .slides li'),
    currentIdx5 = 0,
    slideCount5 = slide5.length,
    slideWidth5 = 515,
    slideMargin5 = 20,
    prevBtn5 = document.querySelector('#movie5 .prev'),
    nextBtn5 = document.querySelector('#movie5 .next');

slides5.style.width = (slideWidth5 + slideMargin5) * slideCount5 - slideMargin5 + 'px';

function moveSlide5(num) {
    slides5.style.left = (slideWidth5 + slideMargin5) * -num + "px";
    currentIdx5 = num;
}
nextBtn5.addEventListener('click', function () {
    if (currentIdx5 < slideCount5 - 3) {
        moveSlide5(currentIdx5 + 1);
    }
});
prevBtn5.addEventListener('click', function () {
    if (currentIdx5 > 0) {
        moveSlide5(currentIdx5 - 1);
    }
});


//네번째꺼 6 

var slides6 = document.querySelector('#movie6 .slides'),
    slide6 = document.querySelectorAll('#movie6 .slides li'),
    currentIdx6 = 0,
    slideCount6 = slide6.length,
    slideWidth6 = 515,
    slideMargin6 = 20,
    prevBtn6 = document.querySelector('#movie6 .prev'),
    nextBtn6 = document.querySelector('#movie6 .next');

slides6.style.width = (slideWidth6 + slideMargin6) * slideCount6 - slideMargin6 + 'px';

function moveSlide6(num) {
    slides6.style.left = (slideWidth6 + slideMargin6) * -num + "px";
    currentIdx6 = num;
}
nextBtn6.addEventListener('click', function () {
    if (currentIdx6 < slideCount6 - 3) {
        moveSlide6(currentIdx6 + 1);
    }
});
prevBtn6.addEventListener('click', function () {
    if (currentIdx6 > 0) {
        moveSlide6(currentIdx6 - 1);
    }
});


//네번째꺼 7

var slides7 = document.querySelector('#movie7 .slides'),
    slide7 = document.querySelectorAll('#movie7 .slides li'),
    currentIdx7 = 0,
    slideCount7 = slide7.length,
    slideWidth7 = 515,
    slideMargin7 = 20,
    prevBtn7 = document.querySelector('#movie7 .prev'),
    nextBtn7 = document.querySelector('#movie7 .next');

slides7.style.width = (slideWidth7 + slideMargin7) * slideCount7 - slideMargin7 + 'px';

function moveSlide7(num) {
    slides7.style.left = (slideWidth7 + slideMargin7) * -num + "px";
    currentIdx7 = num;
}
nextBtn7.addEventListener('click', function () {
    if (currentIdx7 < slideCount7 - 3) {
        moveSlide7(currentIdx7 + 1);
    }
});
prevBtn7.addEventListener('click', function () {
    if (currentIdx7 > 0) {
        moveSlide7(currentIdx7 - 1);
    }
});






//네번째꺼 8 

var slides8 = document.querySelector('#movie8 .slides'),
    slide8 = document.querySelectorAll('#movie8 .slides li'),
    currentIdx8 = 0,
    slideCount8 = slide8.length,
    slideWidth8 = 515,
    slideMargin8 = 20,
    prevBtn8 = document.querySelector('#movie8 .prev'),
    nextBtn8 = document.querySelector('#movie8 .next');

slides8.style.width = (slideWidth8 + slideMargin8) * slideCount8 - slideMargin8 + 'px';

function moveSlide8(num) {
    slides8.style.left = (slideWidth8 + slideMargin8) * -num + "px";
    currentIdx8 = num;
}
nextBtn8.addEventListener('click', function () {
    if (currentIdx8 < slideCount8 - 3) {
        moveSlide8(currentIdx8 + 1);
    }
});
prevBtn8.addEventListener('click', function () {
    if (currentIdx8 > 0) {
        moveSlide8(currentIdx8 - 1);
    }
});

