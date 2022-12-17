<%@ page import="com.example.demoworking.Database" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demoworking.models.Subject" %>
<%! List<Subject> subjects;%>
<% Database db = (Database) session.getAttribute("database");
    subjects = db.readSubjects();
%>
<style>
    .select-box-subject {
        position: relative;
        display: block;
        width: 100%;
        font-family: "Open Sans", "Helvetica Neue", "Segoe UI", "Calibri",
        "Arial", sans-serif;
        font-size: 18px;
        color: #2a2a2a;
    }

    @media (min-width: 768px) {
        .select-box-subject {
            width: 70%;
        }
    }

    @media (min-width: 992px) {
        .select-box-subject {
            width: 50%;
        }
    }

    @media (min-width: 1200px) {
        .select-box-subject {
            width: 30%;
        }
    }

    .select-box-subject__current {
        position: relative;
        cursor: pointer;
        outline: none;
    }

    .select-box-subject__current:focus + .select-box-subject__list {
        opacity: 1;
        -webkit-animation-name: none;
        animation-name: none;
    }

    .select-box-subject__current:focus + .select-box-subject__list .select-box-subject__option {
        cursor: pointer;
    }

    .select-box-subject__current:focus .select-box-subject__icon {
        transform: translateY(-50%) rotate(180deg);
    }

    .select-box-subject__icon {
        position: absolute;
        top: 50%;
        right: 15px;
        transform: translateY(-50%);
        width: 20px;
        opacity: 0.3;
        transition: 0.2s ease;
    }

    .select-box-subject__value {
        display: flex;
    }

    .select-box-subject__input {
        display: none;
    }

    .select-box-subject__input:checked + .select-box-subject__input-text {
        display: block;
    }

    .select-box-subject__input-text {
        display: none;
        width: 100%;
        margin: 0;
        padding: 15px;
        background-color: hsl(216, 45%, 98%);
        border: 1px solid hsl(216, 45%, 88%);
        border-radius: 15px;
    }

    .select-box-subject__list {
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

    .select-box-subject__option {
        display: block;
        padding: 15px;
        background-color: #fff;
    }

    .select-box-subject__option:hover,
    .select-box-subject__option:focus {
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
<div class="select-box-subject">
    <div class="select-box-subject__current" tabindex="1">
        <%
            for (Subject subject : subjects) {
                out.println("<div class=\"select-box-subject__value\">");
                out.println(subject.dropDownInput());
                out.println("</div>");
            }
        %>
        <div class="select-box-subject__value">
            <input
                    class="select-box-subject__input"
                    type="radio"
                    id="subject0"
                    value="0"
                    name="selectedSubject"
                    checked="checked"
            />
            <p class="select-box-subject__input-text">Subject</p>
        </div>
        <img
                class="select-box-subject__icon"
                src="http://cdn.onlinewebfonts.com/svg/img_295694.svg"
                alt="Arrow Icon"
                aria-hidden="true"
        />
    </div>
    <ul class="select-box-subject__list">
        <%
            for (Subject subject : subjects)
                out.println(subject.dropDownTitle());
        %>
    </ul>
</div>