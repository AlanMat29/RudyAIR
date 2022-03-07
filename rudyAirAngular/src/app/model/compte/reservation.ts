import { Vol } from '../vol/vol';
import { Client } from './client';
import { Passager } from './passager';

export class Reservation {
  private _id: number | undefined;
  private _statut: boolean | undefined;
  private _animaux: number | undefined;
  private _bagage: number | undefined;
  private _passager: Passager | undefined;
  private _vol: Vol | undefined;
  private _siege: string | undefined;
  private _client: Client | undefined;

  constructor(
    id?: number,
    statut?: boolean,
    animaux?: number,
    bagage?: number,
    passager?: Passager,
    vol?: Vol,
    siege?: string,
    client?: Client
  ) {
    this._id = id;
    this._statut = statut;
    this._animaux = animaux;
    this._bagage = bagage;
    this._passager = passager;
    this._vol = vol;
    this._siege = siege;
    this._client = client;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter statut
   * @return {boolean }
   */
  public get statut(): boolean | undefined {
    return this._statut;
  }

  /**
   * Getter animaux
   * @return {number }
   */
  public get animaux(): number | undefined {
    return this._animaux;
  }

  /**
   * Getter bagage
   * @return {number }
   */
  public get bagage(): number | undefined {
    return this._bagage;
  }

  /**
   * Getter passager
   * @return {Passager }
   */
  public get passager(): Passager | undefined {
    return this._passager;
  }

  /**
   * Getter vol
   * @return {Vol }
   */
  public get vol(): Vol | undefined {
    return this._vol;
  }

  /**
   * Getter siege
   * @return {string }
   */
  public get siege(): string | undefined {
    return this._siege;
  }

  /**
   * Getter client
   * @return {Client }
   */
  public get client(): Client | undefined {
    return this._client;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter statut
   * @param {boolean } value
   */
  public set statut(value: boolean | undefined) {
    this._statut = value;
  }

  /**
   * Setter animaux
   * @param {number } value
   */
  public set animaux(value: number | undefined) {
    this._animaux = value;
  }

  /**
   * Setter bagage
   * @param {number } value
   */
  public set bagage(value: number | undefined) {
    this._bagage = value;
  }

  /**
   * Setter passager
   * @param {Passager } value
   */
  public set passager(value: Passager | undefined) {
    this._passager = value;
  }

  /**
   * Setter vol
   * @param {Vol } value
   */
  public set vol(value: Vol | undefined) {
    this._vol = value;
  }

  /**
   * Setter siege
   * @param {string } value
   */
  public set siege(value: string | undefined) {
    this._siege = value;
  }

  /**
   * Setter client
   * @param {Client } value
   */
  public set client(value: Client | undefined) {
    this._client = value;
  }
}
