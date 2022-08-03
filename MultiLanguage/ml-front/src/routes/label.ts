/** @type {import('@sveltejs/kit').RequestHandler} */
export async function GET() {
    const url = "http://localhost:8080/label"
    const response = await fetch(url, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
        }
    })
    return {
        status: 200,
        headers: {
        'access-control-allow-origin': '*'
        },
        body: await response.json()
    };
}