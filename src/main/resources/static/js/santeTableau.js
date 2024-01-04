let tabs = document.querySelectorAll(".info-box li a");
let panels = document.querySelectorAll(".info-box article");

for (let i = 0; i < tabs.length; i++) {
    let tab = tabs[i];
    setTabHandler(tab, i);
}

function setTabHandler(tab, tabPos) {
    tab.onclick = function () {
        for (let i = 0; i < tabs.length; i++) {
            tabs[i].className = "";
        }

        tab.className = "active";

        for (let i = 0; i < panels.length; i++) {
            panels[i].className = "";
        }

        panels[tabPos].className = "active-panel";
    };
}