// 이미지 페이드 인 효과

window.onload = function () {
    window.addEventListener("scroll", function (e) {
        scrollEvent();
    });
}

var scrollEvent = function () {
    // 사용자 모니터 화면 높이 + 스크롤이 움직인 높이
    var scroll = window.innerHeight + window.scrollY;
    console.log(scroll);
    // 애니메이션 효과를 넣을 DOM 객체 배열
    var itemList = document.querySelectorAll(".list_cont");
    console.log(itemList)
    Array.prototype.forEach.call(itemList, function (e) {
        // 객체 위치와 높이 비교 : 화면에 표출되는 높이인지 체크
        if (e.offsetTop < scroll) {
            // 객체 animatable 클래스 지우고, animated 클래스 추가
            e.classList.remove("animatable");
            e.classList.add("animated");
        }
    });
}