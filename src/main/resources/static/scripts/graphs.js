let currentCompanyTicker = document.getElementById('ticker');
console.log(currentCompanyTicker.innerHTML);


google.charts.load('current', {'packages':['corechart']});
// google.charts.setOnLoadCallback(drawVisualization);
var graphContents = [];




function drawVisualization(output) {
    // Some raw data (grabbing from the api)
    var data = google.visualization.arrayToDataTable(output);
    var options = {
        title : 'Daily Investment Production by Company',
        vAxis: {title: 'Stock'},
        hAxis: {title: 'Daily'},
        seriesType: 'line',
        series: {12: {type: 'line'}}
    };

    var chart = new google.visualization.LineChart(document.getElementById('graph_charts'));
    chart.draw(data, options);
}

var GRAPHS_CONTAINER = document.querySelector("#graph_charts");

async function firstGraph(stockSymbol) {
    var url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + stockSymbol + "&outputsize=compact&datatype=json&apikey=4LTMQQHJMWN9C79N";
    try {
        var response = await fetch(url);
        var data = await response.json();
        console.log(data);
        var series = data["Time Series (Daily)"];
        var output = [];

        for (key in series) {
            var price = series[key]["4. close"];
            var
                price = parseFloat(price);
            output.push([key, price])
        }
        output.reverse();
        output.unshift(["month", data["Meta Data"]["2. Symbol"]]);
        graphContents = output;
        console.log(output);
        google.charts.setOnLoadCallback(function (){
            drawVisualization(output)
        });

    } catch (e) {
        console.log("Error!", e);
    }
}

document.addEventListener('DOMContentLoaded', function () {
    firstGraph(currentCompanyTicker.innerHTML.toUpperCase());

});



async function addNewTicker(){
    var stockSymbol = document.querySelector("#searchbox").value.toUpperCase();
    console.log(stockSymbol);
    var url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + stockSymbol + "&outputsize=compact&datatype=json&apikey=4LTMQQHJMWN9C79N";
    try {
        var response = await fetch(url);
        var data = await response.json();
        var series = data["Time Series (Daily)"];
        var output = [];

        for (key in series) {
            var price = series[key]["4. close"];
            var price = parseFloat(price);
            output.push([key, price])
        }
        output.reverse();
        var newSymbolData = [];

        newSymbolData.push(stockSymbol);
        output.forEach(function(price) {
            newSymbolData.push(price[1]);
        });
        graphContents.forEach(function(row, index) {
            graphContents[index].push(newSymbolData[index]);
        });
        drawVisualization(graphContents);

        console.log(graphContents);
    } catch (e) {
        console.log("Error!", e);
    }
}