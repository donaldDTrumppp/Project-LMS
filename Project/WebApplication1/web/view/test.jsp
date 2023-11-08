<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            div.sticky {
                position: -webkit-sticky;
                position: sticky;
                top: 0;
                background-color: yellow;
                padding: 50px;
                font-size: 20px;
            }

            .popup {
                position: fixed;
                z-index: 1;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                overflow: auto;
                background-color: rgba(0, 0, 0, 0.4);
                display: none;
            }
            .popup-content {
                background-color: white;
                margin: 10% auto;
                padding: 20px;
                border: 1px solid #888888;
                width: 30%;
                font-weight: bolder;
            }
            .popup-content button {
                display: block;
                margin: 0 auto;
            }
            .show {
                display: block;
            }
            h1 {
                color: green;
            }
            .popup-content{
                font-size: 20px;
            }
            p{
                text-align: center;
            }
            .popupBtn{
                display: flex;
                flex-direction: row;
                justify-content: center;
            }

            .popupBtn button{
                width: 80px;
                border: 1px solid black;
                border-radius: 12px;
                padding: 5px;
            }

            .popupBtn button:hover{
                background-color: black;
                color: white;
            }

            .rw{
                border-radius: 12px;
                background-color: #0075b0;
                color:white;
                margin-left: 40px;
            }

            #myButton{
                border-radius: 12px;
                background-color: red;
                color: white;
            }

            .ac{
                width: 20px;
            }
        </style>
    </head>
    <body>
        <button id ="myButton" type ="button" class ="btn">RETAKE</button>
        <div id="myPopup" class="popup">
            <div class="popup-content">

                <p>Are you sure you want to enter this quiz ?</p>
                <div class = "popupBtn">
                    <button id="go">
                        OK
                    </button>
                    <button id="closePopup">
                        Close
                    </button>
                </div>
            </div>
        </div>

       ${q.timeLimit}
       ${q.quizName}
       ${q.chapter.chapterID}
       ${q.subject.subjectID}
       ${q.cls.classID}
       ${q.type}
       ${q.createdBy.fullName}
       ${q.createdAt}
       ${q.status}
       ${type}
       

        <script type ="text/javascript">
            document.getElementById("myButton").addEventListener("click", function () {
                document.getElementById("myPopup").classList.add("show");
            });
            document.getElementById("closePopup").addEventListener("click", function () {
                document.getElementById("myPopup").classList.remove("show");
            });
            window.addEventListener("click", function (event) {
                if (event.target == document.getElementById("myPopup")) {
                    document.getElementById("myPopup").classList.remove("show");
                }
            });
        </script>
    </body>
</html>
