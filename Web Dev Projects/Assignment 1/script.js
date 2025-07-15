// Functions for courses.html

function searchCourses() {
  var searchTerm = document.getElementById("course-search").value.toLowerCase();
  var courseList = document.getElementById("course-list");
  var courses = courseList.getElementsByTagName("li");
  var filterValue = document.getElementById("level-filter").value;

  for (var i = 0; i < courses.length; i++) {
    var course = courses[i];
    var courseName = course.querySelector("h3").innerText.toLowerCase();
    var courseLevel = course.getElementsByTagName("p")[0].innerText.toLowerCase().split(": ")[1];

    if (courseName.includes(searchTerm) && isCourseVisible(courseLevel, filterValue)) {
      course.style.display = "block";
    } else {
      course.style.display = "none";
    }
  }
  console.log("Clicked to search courses");
}


function filterCourses() {
  var searchTerm = document.getElementById("course-search").value.toLowerCase();
  var filterValue = document.getElementById("level-filter").value;
  var courseList = document.getElementById("course-list");
  var courses = courseList.getElementsByTagName("li");

  for (var i = 0; i < courses.length; i++) {
    var course = courses[i];
    var courseName = course.querySelector("h3").innerText.toLowerCase();
    var courseLevel = course.getElementsByTagName("p")[0].innerText.toLowerCase().split(": ")[1];

    if (courseName.includes(searchTerm) && isCourseVisible(courseLevel, filterValue)) {
      course.style.display = "block";
    } else {
      course.style.display = "none";
    }
  }
  console.log("Clicked to filter courses");
}

function sortCourses() {
  var sortOrder = document.getElementById("sort-order").value;
  var courseList = document.getElementById("course-list");
  var courses = courseList.getElementsByTagName("li");

  var sortedCourses = Array.from(courses).sort(function(a, b) {
    var levelA = a.getElementsByTagName("p")[0].innerText.toLowerCase().split(": ")[1];
    var levelB = b.getElementsByTagName("p")[0].innerText.toLowerCase().split(": ")[1];

    var levelValues = {
      "beginner": 1,
      "intermediate": 2,
      "advanced": 3
    };

    if (sortOrder === "asc") {
      return levelValues[levelA] - levelValues[levelB];
    } else {
      return levelValues[levelB] - levelValues[levelA];
    }
  });

  for (var i = 0; i < sortedCourses.length; i++) {
    courseList.appendChild(sortedCourses[i]);
  }
  console.log("Clicked to sort courses");
}

function isCourseVisible(courseLevel, filterValue) {
  if (filterValue === "" || courseLevel === filterValue) {
    return true;
  }
  return false;
}