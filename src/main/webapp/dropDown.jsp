<%@ page import="com.example.demoworking.Database" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demoworking.models.Class" %>
<style>
    .select-box {
        position: relative;
        display: block;
        width: 100%;
        font-family: "Open Sans", "Helvetica Neue", "Segoe UI", "Calibri",
        "Arial", sans-serif;
        font-size: 18px;
        color: #2a2a2a;
    }

    @media (min-width: 768px) {
        .select-box {
            width: 70%;
        }
    }

    @media (min-width: 992px) {
        .select-box {
            width: 50%;
        }
    }

    @media (min-width: 1200px) {
        .select-box {
            width: 30%;
        }
    }

    .select-box__current {
        position: relative;
        cursor: pointer;
        outline: none;
    }

    .select-box__current:focus + .select-box__list {
        opacity: 1;
        -webkit-animation-name: none;
        animation-name: none;
    }

    .select-box__current:focus + .select-box__list .select-box__option {
        cursor: pointer;
    }

    .select-box__current:focus .select-box__icon {
        transform: translateY(-50%) rotate(180deg);
    }

    .select-box__icon {
        position: absolute;
        top: 50%;
        right: 15px;
        transform: translateY(-50%);
        width: 20px;
        opacity: 0.3;
        transition: 0.2s ease;
    }

    .select-box__value {
        display: flex;
    }

    .select-box__input {
        display: none;
    }

    .select-box__input:checked + .select-box__input-text {
        display: block;
    }

    .select-box__input-text {
        display: none;
        width: 100%;
        margin: 0;
        padding: 15px;
        background-color: hsl(216, 45%, 98%);
        border: 1px solid hsl(216, 45%, 88%);
        border-radius: 15px;
    }

    .select-box__list {
        position: absolute;
        width: 100%;
        padding: 0;
        list-style: none;
        opacity: 0;
        -webkit-animation-name: HideList;
        animation-name: HideList;
        -webkit-animation-duration: 0.5s;
        animation-duration: 0.5s;
        -webkit-animation-delay: 0.5s;
        animation-delay: 0.5s;
        -webkit-animation-fill-mode: forwards;
        animation-fill-mode: forwards;
        -webkit-animation-timing-function: step-start;
        animation-timing-function: step-start;
        box-shadow: 0 15px 30px -10px rgba(0, 0, 0, 0.1);
    }

    .select-box__option {
        display: block;
        padding: 15px;
        background-color: #fff;
    }

    .select-box__option:hover,
    .select-box__option:focus {
        color: #546c84;
        background-color: #fbfbfb;
    }

    @-webkit-keyframes HideList {
        from {
            transform: scaleY(1);
        }
        to {
            transform: scaleY(0);
        }
    }

    @keyframes HideList {
        from {
            transform: scaleY(1);
        }
        to {
            transform: scaleY(0);
        }
    }
</style>
<%! List<Class> classes;%>
<% Database db = (Database) session.getAttribute("database");
    classes = db.readClasses();
%>
<div class="select-box">
    <div class="select-box__current" tabindex="1">
        <%
            for (Class c : classes) {
                out.println("<div class=\"select-box__value\">");
                out.println(c.dropDownInput());
                out.println("</div>");
            }
        %>
        <div class="select-box__value">
            <input
                    class="select-box__input"
                    type="radio"
                    id="0"
                    value="0"
                    name="selectedClass"
                    checked="checked"
            />
            <p class="select-box__input-text">Select a class</p>
        </div>
        <img
                class="select-box__icon"
                src="http://cdn.onlinewebfonts.com/svg/img_295694.svg"
                alt="Arrow Icon"
                aria-hidden="true"
        />
    </div>
    <ul class="select-box__list">
        <%
            for (Class c : classes)
                out.println(c.dropDownTitle());
        %>
    </ul>
</div>