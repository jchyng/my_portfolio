const todoForm = document.getElementById("todo-form");
const inputTodo = document.querySelector(".input-todo");
const todoList = document.getElementById("toDo-list");

const TODOS_KEY = "todo"
let toDos = [];

function saveToDos(){
    localStorage.setItem(TODOS_KEY, JSON.stringify(toDos));
}
function deleteTodo(event){
    const li = event.target.parentElement;
    li.remove();
    toDos = toDos.filter((toDo) => toDo.id !== parseInt(li.id));
    console.log(li.id);
    saveToDos();
}
function checkToDo(span){
    const li = span.parentElement;
    span.classList.toggle('checked');
    const index = toDos.findIndex(todo => todo.id === parseInt(li.id));
    
    if(toDos[index].state === 'checked')
        toDos[index].state = 'unchecked';
    else if(toDos[index].state === 'unchecked')
        toDos[index].state = 'checked';    
        
    saveToDos();
}
function paintToDo(newTodo){
    const li = document.createElement("li");
    li.id = newTodo.id;
    const checkBox = document.createElement("input");
    const span = document.createElement("span");
    const button = document.createElement('button');

    checkBox.setAttribute("type", "checkBox");
    checkBox.addEventListener("click",()=>
        checkToDo(span)
    );
    span.innerText = newTodo.text;
    button.addEventListener("click",deleteTodo);
    
    li.appendChild(checkBox);
    li.appendChild(span);
    li.appendChild(button);
    todoList.appendChild(li);

    if(newTodo.state === 'checked'){
        span.className = 'checked';
        checkBox.setAttribute('checked',true);
    }
}
function handleToDoSubmit(event){
    event.preventDefault();
    const newTodo = inputTodo.value;
    inputTodo.value = ""
    const newTodoObj = {
        text:newTodo,
        id: Date.now(),
        state: 'unchecked',
    };
    toDos.push(newTodoObj);
    paintToDo(newTodoObj);
    saveToDos();
}

todoForm.addEventListener("submit",handleToDoSubmit);

const savedToDos = localStorage.getItem(TODOS_KEY);

if(savedToDos !== null){
    const parsedToDos = JSON.parse(savedToDos);
    toDos = parsedToDos;
    parsedToDos.forEach(paintToDo);
}
