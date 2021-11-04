const devBaseURL = '';
const proBaseURL = '';


export const BASE_URL = process.env.NODE_ENV === 'development' ? devBaseURL: proBaseURL;

export const TIMEOUT = 5000;

const DEFAULT_APIS = {
    get_list: "/list",
}
const MOCK_APIS = {
    get_list: '../mock/list.json',
   
  };

export const getEnv=() => {
   // return environment.production;
}

export const getEndpoint=(name)=> {
    return BASE_URL + DEFAULT_APIS[name];
    // return ENV.baseUrl + path;
}
export const getMockEndpoint=(name)=> {
    return BASE_URL + MOCK_APIS[name];
    // return ENV.baseUrl + path;
}
export const getBackEndDomain= () => {
   // return environment.apiUrl;
}