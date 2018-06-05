<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <!DOCTYPE html>
        <html lang="ko">

        <head>
            <%@ include file="/WEB-INF/jspf/head.jspf" %>
        </head>

        <body>
            <%@ include file="/WEB-INF/jspf/nav.jspf" %>

                <!-- Page Header -->
                <!-- Set your background image for this header on the line below. -->
                
                <header class="intro-header">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="slides">
                                <%@ include file="/WEB-INF/jspf/slider.jspf"%>
                            </div>
                        </div>
                    </div>
                </header>

                <!-- Main Content -->
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                            <c:if test="${query!=null}">
                                <c:out value="${query}" escapeXml="true" /> (으)로 검색된
                            </c:if>
                            <c:if test="${category!=null}">
                                <c:out value="${category}" escapeXml="true" /> 카테고리에
                            </c:if>
                            <c:if test="${tag!=null}">
                                <c:out value="${tag}" escapeXml="true" /> 태그에
                            </c:if>
                            <c:if test="${postPage.totalElements>0}">
                                총 ${postPage.totalElements} 개의 글이 있습니다.
                            </c:if>
                            <c:if test="${postPage.totalElements==0}">
                                글이 없습니다.
                            </c:if>
                            <c:forEach var="post" items="${postPage.content}">
                                <div class="post-preview">
                                    <a href="/post/${post.id}">
                                        <h2 class="post-title">
                                            <c:out value="${post.title}" escapeXml="true"></c:out>
                                        </h2>
                                        <h3 class="post-subtitle">
                                            <c:out value="${post.subtitle}" escapeXml="true"></c:out>
                                        </h3>
                                    </a>
                                    <p class="post-meta">Posted by
                                        <a href="#">${post.name}</a> in
                                        <a href="/post/list?category=${post.category.id}">
                                            <c:out value="${post.category.name}" escapeXml="true" />
                                        </a> on ${post.regDate}</p>
                                </div>
                                <hr>
                            </c:forEach>

                            <!-- Pager -->
                            <ul class="pager">
                                <c:if test="${!postPage.first}">
                                    <li class="previous">
                                        <a href="?<c:if test=" ${categoryId> 0}">category=${categoryId}&</c:if>page=${postPage.number-1}">&larr; Newer Posts</a>
                                </li>
                                </c:if>
                                <c:if test="${!postPage.last}">
                                    <li class="next">
                                        <a href="?<c:if test=" ${categoryId> 0}">category=${categoryId}&</c:if>page=${postPage.number+1}">Older Posts &rarr;</a>
                                </li>
                                </c:if>
                            </ul>
                        </div>
                    </div>
                </div>


                <hr>

                <%@ include file="/WEB-INF/jspf/footer.jspf" %>
                    <script src="/js/script.js"></script>
                    <script src="/js/weather.js"></script>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
                    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

                    <script>
                        $(document).ready(function () {
                            $('.slides').bxSlider({
                                mode: 'horizontal',
                                //slideSelector: "",
                                //infiniteLoop: !0,
                                //hideControlOnEnd: !0,
                                speed: 800,
                                adaptiveHeight: true,
                                useCSS: false,
                                easing: 'easeOutCubic',
                                onSlideAfter: function () {
                                    $('.timer, #cityname, #city-forecast').addClass('on');
                                }

                                /* slideMargin: 0,
                                startSlide: 0,
                                randomStart: !1,
                                captions: !1,
                                ticker: !1,
                                tickerHover: !1,
                                
                                adaptiveHeightSpeed: 500,
                                video: !1,
                                useCSS: !0,
                                preloadImages: "visible",
                                responsive: !0,
                                slideZIndex: 50,
                                wrapperClass: "bx-wrapper",
                                touchEnabled: !0,
                                swipeThreshold: 50,
                                oneToOneTouch: !0,
                                preventDefaultSwipeX: !0,
                                preventDefaultSwipeY: !1,
                                ariaLive: !0,
                                ariaHidden: !0,
                                keyboardEnabled: !1,
                                pager: !0,
                                pagerType: "full",
                                pagerShortSeparator: " / ",
                                pagerSelector: null,
                                buildPager: null,
                                pagerCustom: null,
                                controls: !0,
                                nextText: "Next",
                                prevText: "Prev",
                                nextSelector: null,
                                prevSelector: null,
                                autoControls: !1,
                                startText: "Start",
                                stopText: "Stop",
                                autoControlsCombine: !1,
                                autoControlsSelector: null,
                                auto: !1,
                                pause: 4e3,
                                autoStart: !0,
                                autoDirection: "next",
                                stopAutoOnClick: !1,
                                autoHover: !1,
                                autoDelay: 0,
                                autoSlideForOnePage: !1,
                                minSlides: 1,
                                maxSlides: 1,
                                moveSlides: 0,
                                slideWidth: 0,
                                shrinkItems: !1,
                                onSliderLoad: function () {
                                    
                                },
                                onSlideBefore: function () {
                                    return !0
                                },
                                onSlideAfter: function () {
                                    return !0
                                    $('.timer').addClass('on');
                                },
                                onSlideNext: function () {
                                    return !0
                                },
                                onSlidePrev: function () {
                                    return !0
                                },
                                onSliderResize: function () {
                                    return !0
                                } */
                            });
                        });
                    </script>
        </body>

        </html>