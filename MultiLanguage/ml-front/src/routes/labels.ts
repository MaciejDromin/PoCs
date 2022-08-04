import type { RequestHandler } from "@sveltejs/kit";
import type { Label } from "../lib/Label"

/** @type {import('@sveltejs/kit').RequestHandler} */
export async function GET() {
    const url = "http://localhost:8080/labels"
    const response = await fetch(url, {
        method: 'GET',
        headers: {
            'Accept': 'application/json'
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

/** @type {import('@sveltejs/kit').RequestHandler} */
export const POST: RequestHandler<Label> = async ({ request }) => {
    const url = "http://localhost:8080/labels"
    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        body: JSON.stringify(await request.json())
    })
    return {
        status: 200,
        headers: {
            'access-control-allow-origin': '*'
        },
        body: await response.json()
    };
}