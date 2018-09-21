var NEWS_FEED_CONTAINER = document.querySelector("#news_data");

function requestURL() {
    var
        BASE_URL = "https://newsapi.org/v2/top-headlines?",
        COUNTRY_PARAM = "country=us&",
        ARTICLE_CATEGORY = "category=business&",
        NEWSFEED_APIKEY = "apiKey=99df6baec7fb440291394e15ceb17586"

    return [BASE_URL, COUNTRY_PARAM, ARTICLE_CATEGORY, NEWSFEED_APIKEY].join('')
}

async function fetchArticles() {
    try {
        var response = await fetch(requestURL())
        var data = await response.json();
        return data.articles;
    } catch (e) {
        console.log("Error!", e);
    }
}

async function buildArticlesHTML(){
    var articlesArray = await fetchArticles()

    var articlesHTML = "";

    for await(let article of articlesArray){
        articlesHTML += `
      <div class='article-container'>
          <h2 class='article-title'>${article.title}</h2>
          <p class='article-description'>${article.description}</p>
          <p class='article-timestamp'>${article.publishedAt}</p>
          <h3 class='article-author'>By ${article.author}</h3>
          <img src='${article.urlToImage}' alt='${article.title}'>
          <p class='article-content'>${article.content}</p>
      </div>
    `
    }

    console.log(articlesHTML)
    NEWS_FEED_CONTAINER.insertAdjacentHTML('afterbegin', articlesHTML)
}


document.addEventListener('DOMContentLoaded', function () {
    buildArticlesHTML()
});