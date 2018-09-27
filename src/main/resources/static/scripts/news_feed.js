var NEWS_FEED_CONTAINER = document.querySelector("#news_data");

function requestURL() {
    var
        BASE_URL = "https://newsapi.org/v2/top-headlines?",
        COUNTRY_PARAM = "country=us&",
        ARTICLE_CATEGORY = "category=business&",
        // NEWSFEED_APIKEY = "apiKey=99df6baec7fb440291394e15ceb17586"
        NEWSFEED_APIKEY = "apiKey=be56e2bd456c4178ba8b9bc080a0d860";

    return [BASE_URL, COUNTRY_PARAM, ARTICLE_CATEGORY, NEWSFEED_APIKEY].join('')
}

async function fetchArticles() {
    try {
        var response = await fetch(requestURL());
        var data = await response.json();
        return data.articles;
    } catch (e) {
        console.log("Error!", e);
    }
}

async function buildArticlesHTML() {
    var articlesArray = await fetchArticles();
    var articlesHTML = "";
    var count = 0;
    for await(let article of articlesArray) {
        if(article.title === null) {
            continue;
        }else if(article.description === null) {
            continue;
        }else if(article.publishedAt === null) {
            continue;
        }else if(article.author === null){
            continue;
        }else if(article.urlToImage === null) {
            continue;
        }
        count ++;
        if(count === 11){
            break;
        }
        articlesHTML += `

      <div class='article-container mb-2'>
      <article class="card">
          <a href="${article.url}" target="_blank"><h2 class='article-title'>${article.title}</h2>
          <p class='article-description'>${article.description}</p>
          <div class="newsfeed-img">
          <img src='${article.urlToImage}' alt='${article.title}'>
          </div>
          </a>
      </article>
      </div>
    `
    }
    NEWS_FEED_CONTAINER.insertAdjacentHTML('afterbegin', articlesHTML)
}

document.addEventListener('DOMContentLoaded', function () {

    return buildArticlesHTML()
});