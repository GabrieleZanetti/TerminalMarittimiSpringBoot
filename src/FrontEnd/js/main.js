function doLogin() 
{
    const username = document.getElementById("username").value;
    const password = CryptoJS.MD5(document.getElementById("password").value).toString();
    const email = document.getElementById("email").value;

    const request = {
        username: username,
        password: password,
        email: email
    };

    const url = 'http://localhost:8080/api/user/login';

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(request)
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) 
		{
            alert('Login avvenuto con successo!');
			localStorage.setItem('auth', data);
            window.location.href = 'home.html';
        } 
		else 
            alert('Username o password errati!');
    })
    .catch(error => {
        console.error('Errore:', error);
        alert('Si è verificato un errore durante il login.');
    });
}

function doRegister() 
{
	const username = document.getElementById("username").value;
	const password = CryptoJS.MD5(document.getElementById("password").value).toString();
	const email = document.getElementById("email").value;

	const request = {
		username: username,
		password: password,
		email: email
	};

	const url = 'http://localhost:8080/api/user/register';

	fetch(url, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(request)
	})
	.then(response => response.json())
	.then(data => {
		if (data.success) 
		{
			alert('Registrazione avvenuta con successo!');
			window.location.href = 'login.html';
		} 
		else 
			alert('Errore durante la registrazione!');
	})
	.catch(error => {
		console.error('Errore:', error);
		alert('Si è verificato un errore durante la registrazione.');
	});
}

function doLogout()
{
	localStorage.setItem('auth', null);
	window.location.href = 'login.html';
}

function loadRoles() 
{
  const ruoli = [
    { value: "OperatoreLogistica", label: "Operatore Logistica" },
    { value: "Manutentore", label: "Manutentore" },
    { value: "Coordinatore", label: "Coordinatore" },
    { value: "Carrellista", label: "Carrellista" },
    { value: "AddettoDocumentazione", label: "Addetto alla Documentazione" },
    { value: "AddettoUfficioMerci", label: "Addetto Ufficio Merci" },
    { value: "TecnicoSpedizioni", label: "Tecnico delle Spedizioni" },
    { value: "TecnicoTrasporti", label: "Tecnico dei Trasporti" }
  ];

  const select = document.getElementById('ruoloStaff');
  select.innerHTML = '';

  const defaultOption = document.createElement('option');
  defaultOption.value = '';
  defaultOption.textContent = '-- Seleziona Ruolo --';
  select.appendChild(defaultOption);

  ruoli.forEach(({ value, label }) => {
    const opt = document.createElement('option');
    opt.value = value;
    opt.textContent = label;
    select.appendChild(opt);
  });
}


function addNave() 
{
  const nome = document.getElementById("nomeNave").value;

  const request = {
    nome: nome,
  };

  fetch("http://localhost:8080/api/nave", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(request),
  })
    .then((res) => res.json())
    .then(() => {
      alert("Nave aggiunta con successo!");
      document.getElementById("naveForm").reset();
    })
    .catch((err) => {
      console.error("Errore:", err);
      alert("Errore durante l'aggiunta della nave.");
    });
}

function addPorto() 
{
  const nome = document.getElementById("nomePorto").value;
  const nazione = document.getElementById("nazionePorto").value;

  const request = {
    nome: nome,
    nazione: nazione,
  };

  fetch("http://localhost:8080/api/porto", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(request),
  })
    .then((res) => res.json())
    .then(() => {
      alert("Porto aggiunto con successo!");
      document.getElementById("portoForm").reset();
    })
    .catch((err) => {
      console.error("Errore:", err);
      alert("Errore durante l'aggiunta del porto.");
    });
}

function addViaggio() 
{
  const dataPartenza = document.getElementById("dataPartenza").value;
  const dataAllibramento = document.getElementById("dataAllibramento").value;
  const linea = document.getElementById("linea").value;
  const idNave = parseInt(document.getElementById("idNave").value);
  const idPortoPartenza = parseInt(document.getElementById("portoPartenza").value);
  const idPortoArrivo = parseInt(document.getElementById("portoArrivo").value);

  const request = {
    dataPartenza,
    dataAllibramento,
    linea,
    nave: { id: idNave },
    portoPartenza: { id: idPortoPartenza },
    portoArrivo: { id: idPortoArrivo },
  };

  fetch("http://localhost:8080/api/viaggio", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(request),
  })
    .then((res) => res.json())
    .then(() => {
      alert("Viaggio aggiunto con successo!");
      document.getElementById("viaggioForm").reset();
    })
    .catch((err) => {
      console.error("Errore:", err);
      alert("Errore durante l'aggiunta del viaggio.");
    });
}
