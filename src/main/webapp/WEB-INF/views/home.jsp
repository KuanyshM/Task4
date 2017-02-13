<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <base href="http://demos.telerik.com/kendo-ui/treeview/images">
    <style>html { font-size: 14px; font-family: Arial, Helvetica, sans-serif; }</style>
    <title></title>
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2017.1.118/styles/kendo.common-material.min.css" />
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2017.1.118/styles/kendo.material.min.css" />
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2017.1.118/styles/kendo.material.mobile.min.css" />

    <script src="https://kendo.cdn.telerik.com/2017.1.118/js/jquery.min.js"></script>
    <script src="https://kendo.cdn.telerik.com/2017.1.118/js/kendo.all.min.js"></script>
</head>
<h1>
	Hello world!  
</h1>

<P> </P>
<var></var>

                
  <div id="example">

    <div class="box" style="visibility: hidden">
        <h4>Animation Settings</h4>
        <ul class="options">
            <li>
                <input id="toggle" name="animation" type="radio" />
                <label for="toggle">toggle animation</label>
            </li>
            <li>
                <input id="expand" name="animation" type="radio" checked="checked" />
                <label for="expand">expand animation</label>
            </li>
            <li>
                <input id="opacity" type="checkbox" checked="checked" />
                <label for="opacity">animate opacity</label>
            </li>
        </ul>
    </div>

    <div class="demo-section k-content">
    	<ul id="treeview">
    	
		</ul>

    </div>

    <script>
        $(document).ready(function() {
            var original = $("#treeview").clone(true);

            $(".configuration input").change( function() {
                var treeView = $("#treeview"),
                    clone = original.clone(true);

                treeView.parent().empty().remove();
                $(".demo-section").append(clone);

                initTreeView();
            });

            var initTreeView = function () {
                $("#treeview").width(200)
                    .kendoTreeView({
                        animation: {
                            expand: {
                                effects: getEffects()
                            }
                        }
                    });
            };

            var getEffects = function () {
                return (($("#expand")[0].checked ? "expand:vertical " : "") +
                        ($("#opacity")[0].checked ? "fadeIn" : "")) || false;
            };

            initTreeView();
        });
    </script>

    <style>
        /* demo style, do not show treeview scrollbars */
        div.k-treeview { overflow: visible; }
    </style>
</div>

        <div id="example">
            <div class="demo-section k-content">
                <h4>TreeView with images</h4>
                <div id="treeview-images"></div>
            </div>
            <script>
                $("#treeview-images").kendoTreeView({
                    dataSource: [
                        {
                            text: "Inbox", imageUrl: "../content/web/treeview/mail.png",
                            items: [
                                { text: "Read Mail", imageUrl: "../content/web/treeview/readmail.png" }
                            ]
                        },
                        {
                            text: "Drafts", imageUrl: "../content/web/treeview/edit.png"
                        },
                        {
                            text: "Search Folders", expanded: true, imageUrl: "../content/web/treeview/search.png",
                            items: [
                                { text: "Categorized Mail", imageUrl: "../content/web/treeview/search.png" },
                                { text: "Large Mail", imageUrl: "../content/web/treeview/search.png" },
                                { text: "Unread Mail", imageUrl: "../content/web/treeview/search.png" }
                            ]
                        },
                        {
                            text: "Settings", imageUrl: "../content/web/treeview/settings.png"
                        }
                    ]
                });
            </script>

            <div class="demo-section k-content">
                <h4>TreeView with sprites</h4>
                <div id="treeview-sprites"></div>
            </div>
            <script>
                $("#treeview-sprites").kendoTreeView({
                    dataSource: [{
                        text: "My Documents", expanded: true, spriteCssClass: "rootfolder", items: [
                            {
                                text: "Kendo UI Project", expanded: true, spriteCssClass: "folder", items: [
                                    { text: "about.html", spriteCssClass: "html" },
                                    { text: "index.html", spriteCssClass: "html" },
                                    { text: "logo.png", spriteCssClass: "image" }
                                ]
                            },
                            {
                                text: "New Web Site", expanded: true, spriteCssClass: "folder", items: [
                                    { text: "mockup.jpg", spriteCssClass: "image" },
                                    { text: "Research.pdf", spriteCssClass: "pdf" },
                                ]
                            },
                            {
                                text: "Reports", expanded: true, spriteCssClass: "folder", items: [
                                    { text: "February.pdf", spriteCssClass: "pdf" },
                                    { text: "March.pdf", spriteCssClass: "pdf" },
                                    { text: "April.pdf", spriteCssClass: "pdf" }
                                ]
                            }
                        ]
                    }]
                });
            </script>

            <style>
                #treeview-sprites .k-sprite {
                    background-image: url("../content/web/treeview/coloricons-sprite.png");
                }

                .rootfolder { background-position: 0 0; }
                .folder { background-position: 0 -16px; }
                .pdf { background-position: 0 -32px; }
                .html { background-position: 0 -48px; }
                .image { background-position: 0 -64px; }
            </style>
        </div>

   
</body>
</html>


